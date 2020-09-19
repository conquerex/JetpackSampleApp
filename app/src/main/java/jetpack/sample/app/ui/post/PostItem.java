package jetpack.sample.app.ui.post;

import androidx.annotation.NonNull;

import jetpack.sample.app.data.Post;

/**
 * Created by jongkook on 2020.09.12
 * .
 * PostItem 인스턴스는 View에 해당하는 RecyclerView.ViewHolder 인스턴스의 ViewModel 역할을 한다.
 */
public class PostItem {
    @NonNull
    private final Post post;

    /**
     * PostItem에서는 화면 전환, 다이얼로그 노출 등 안드로이드 시스템과 관련된 작업을 할 수 없는 레이어이므로
     * 다음 레이어로 이벤트를 위임하도록 EventListener를 정의 하였다.
     */
    @NonNull
    private final EventListener eventListener;

    public PostItem(@NonNull Post post, @NonNull EventListener eventListener) {
        this.post = post;
        this.eventListener = eventListener;
    }

    @NonNull
    public Post getPost() {
        return post;
    }

    public String getTitle() {
        return post.getTitle();
    }

    @NonNull
    public EventListener getEventListener() {
        return eventListener;
    }

    public interface EventListener {
        /**
         * 정의한 EventListener를 통해 데이터 바인딩 표현식으로부터
         * onPostClick() 메서드를 호출한다.
         */
        void onPostClick(PostItem postItem);
    }
}
