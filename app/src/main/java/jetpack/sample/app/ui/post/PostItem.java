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

    public PostItem(@NonNull Post post) {
        this.post = post;
    }

    @NonNull
    public Post getPost() {
        return post;
    }

    public String getTitle() {
        return post.getTitle();
    }
}
