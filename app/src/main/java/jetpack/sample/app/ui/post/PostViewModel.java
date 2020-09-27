package jetpack.sample.app.ui.post;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import jetpack.sample.app.data.PostService;
import jetpack.sample.app.util.SingleLiveEvent;
import timber.log.Timber;

/**
 * Created by jongkook on 2020.09.08
 */
public class PostViewModel extends AndroidViewModel implements PostItem.EventListener {

    @NonNull
    private final PostService postService;
    @NonNull
    private final SingleLiveEvent<Throwable> errorEvent;

    // RecyclerView에 표현할 아이템들을 LiveData로 관리
    private final MutableLiveData<List<PostItem>> livePosts = new MutableLiveData<>();
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    // implements PostItem.EventListener 추가 이후
    private final SingleLiveEvent<PostItem> postClickEvent = new SingleLiveEvent<>();

    /**
     * <Dagger2와 ViewModel 설정>
     * 2. ViewModel 생성자 매개 변수를 필드에 할당 시
     * final로 선언하여 외부로부터 변경하지 못하도록 한다.
     */
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>(true);

    /**
     * @Inject 생성자가 있는 모든 클래스에 대해 Dagger는 Factory를 생성합니다
     * --> PostViewModel_Factory
     */
    @Inject
    public PostViewModel(@NonNull Application application,
                         @NonNull PostService postService,
                         @Named("errorEvent") SingleLiveEvent<Throwable> errorEvent) {
        super(application);
        Timber.d(">>>>>> PostViewModel created");
        // 오브젝트 그래프로부터 생성자 주
        this.postService = postService;
        this.errorEvent = errorEvent;
    }

    /**
     * <Dagger2와 ViewModel 설정>
     * 1. ViewModel의 생성 시 필요한 생성자 매개 변수를
     * 오브젝트 그래프의 @Singleton 범위 내에서만 제공 받는다.
     */
    @Inject
    public void loadPosts() {
        compositeDisposable.add(postService.getPosts()
                .flatMapObservable(Observable::fromIterable)
                .map(post -> new PostItem(post, this))
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(postItems -> loading.postValue(false))
                .subscribe(livePosts::setValue, errorEvent::setValue)
        );
    }

    @NonNull
    public MutableLiveData<List<PostItem>> getLivePosts() {
        return livePosts;
    }

    /**
     * ViewModel은 생명중기를 알고 동작한다.
     * 뷰 모델이 파괴될 때, RxJava의 Disposable과 같은 리소스등을 해제할 수 있도록 한다.
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        Timber.d(">>>>>> PostViewModel onCleared");
        compositeDisposable.clear();
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    /**
     * PostItem 클릭 이벤트 구현
     */
    @Override
    public void onPostClick(PostItem postItem) {
        // Fragment로 이벤트를 전달하도록 SingleLiveEvent의 값을 변경한다.
        postClickEvent.setValue(postItem);
    }

    /**
     * PostFragment로 postClickEvent 변수를 노출
     * .
     * PostViewModel이 이벤트를 수신하지만, 이에 대한 처리는 프래그먼트만 할 수 있다.
     * 그러므로 다시 Fragment로 이벤트를 전달해야 한다. ---> LiveData
     * getPostClickEvent() 메서드를 통해 SingleLiveEvent(LiveData)를 노출하여 Fragment가 이를 구독하도록 구현
     */
    public SingleLiveEvent<PostItem> getPostClickEvent() {
        return postClickEvent;
    }
}
