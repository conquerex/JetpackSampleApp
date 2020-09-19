package jetpack.sample.app.di;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/**
 * Created by jongkook on 2020.09.02
 * .
 * 애플리케이션 스코프를 싱글턴으로 관리한다.
 * .
 * <ViewModelProvider.Factory>
 * ViewModel 클래스를 상속하여 정의한 클래스는 개발자가 직접 생성자를 통하여서 인스턴스를 생성할 수 없고,
 * ViewModelProvider.Factory 인터페이스를 필요
 * (https://readystory.tistory.com/176)
 */
@Singleton
public class AppViewModelFactory implements ViewModelProvider.Factory {

    // ViewModel 클래스를 키로 갖는 멀티바인딩된 Map
    // 키 : ViewModelKey
    private Map<Class<? extends ViewModel>, Provider<ViewModel>> creators;

    // 생성자 주입, 멀티 바인딩
    // @Binds : ViewModelModule
    @Inject
    public AppViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
        this.creators = creators;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        // ViewModel 클래스를 키로 하며, ViewModel 객체를 생성하는 Provider를 가져온다.
        Provider<? extends ViewModel> creator = creators.get(modelClass);
        if (creator == null) {
            // 클래스 키로 못찾았다면 적당한 Provider가 있는지, 다시 Map에서 찾는다.
            for (Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> entry : creators.entrySet()) {
                if (modelClass.isAssignableFrom(entry.getKey())) {
                    creator = entry.getValue();
                }
            }
        }

        if (creator == null) {
            throw new IllegalArgumentException("Unknown model class :::: " + modelClass);
        }

        try {
            // Dagger의 Provider로부터 ViewModel 객체 생성 및 변환
            return (T) creator.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
