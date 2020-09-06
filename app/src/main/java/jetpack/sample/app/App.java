package jetpack.sample.app;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import jetpack.sample.app.di.DaggerAppComponent;
import timber.log.Timber;

/**
 * Created by jongkook on 2020.09.01
 */
public class App extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        // 로그용 Timber 설정
        Timber.plant(new Timber.DebugTree());
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        // AppComponent 설정이 끝난 뒤,
        // 컴파일 타임에 DaggerAppComponent가 생성된다.
        /**
         * app == DaggerApplication (이미 app은 만들어 진 상태에서...)
         * AppComponent --> AndroidInjector 상속 (그리고 AppComponent를 구현한 DaggerAppComponent)
         * App에서는 -------> AndroidInjector 반환 (DaggerAppComponent.factory().create)
         * .
         * AppComponent에 등록된 ActivityModule에서 구현된 (그리고 자동으로 생성된)
         * 각 SubComponent 인스턴스에 AndroidInjector를 전달
         */
        return DaggerAppComponent.factory().create(this);
    }
}
