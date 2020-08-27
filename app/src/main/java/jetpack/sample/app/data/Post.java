package jetpack.sample.app.data;

/**
 * Created by jongkook on 2020.08.27
 * .
 * REST API Base Url
 * https://jsonplaceholder.typicode.com/
 */
public class Post {
    private long userId;
    private long id;
    private String title;
    private String body;

    public long getUserId() {
        return userId;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
