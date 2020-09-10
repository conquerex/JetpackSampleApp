package jetpack.sample.app.ui.post;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

/**
 * Created by jongkook on 2020.09.08
 */
public class PostViewModel extends AndroidViewModel {

    /**
     * <Dagger2와 ViewModel 설정>
     * 2. ViewModel 생성자 매개 변수를 필드에 할당 시
     *    final로 선언하여 외부로부터 변경하지 못하도록 한다.
     */
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>(true);

    /**
     * <Dagger2와 ViewModel 설정>
     * 1. ViewModel의 생성 시 필요한 생성자 매개 변수를
     *    오브젝트 그래프의 @Singleton 범위 내에서만 제공 받는다.
     */
    @Inject
    public PostViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadPosts() {
        //
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }
}
