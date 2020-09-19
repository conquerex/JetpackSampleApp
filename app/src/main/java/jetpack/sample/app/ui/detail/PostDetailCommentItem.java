package jetpack.sample.app.ui.detail;

import jetpack.sample.app.data.Comment;
import jetpack.sample.app.data.Post;

/**
 * Created by jongkook on 2020.09.19
 */
public class PostDetailCommentItem extends PostDetailItem {
    private Comment comment;

    public PostDetailCommentItem(Comment comment) {
        this.comment = comment;
    }

    @Override
    public Type getType() {
        return Type.COMMENT;
    }

    public String getName() {
        return comment.getName();
    }

    public String getBody() {
        return comment.getBody();
    }
}
