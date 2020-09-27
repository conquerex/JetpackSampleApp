package jetpack.sample.app.ui.detail;

import jetpack.sample.app.data.Post;

/**
 * Created by jongkook on 2020.09.19
 */
public class PostDetailPostItem extends PostDetailItem {

    private Post post;

    public PostDetailPostItem(Post post) {
        this.post = post;
    }

    @Override
    public Type getType() {
        return Type.POST;
    }

    public String getTitle() {
        return post.getTitle();
    }

    public String getBody() {
        return post.getBody();
    }
}
