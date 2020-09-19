package jetpack.sample.app.ui.detail;

/**
 * Created by jongkook on 2020.09.19
 */
public abstract class PostDetailItem {
    public abstract Type getType();

    public enum Type {
        USER,
        POST,
        COMMENT
    }
}
