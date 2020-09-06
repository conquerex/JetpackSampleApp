package jetpack.sample.app.data;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jongkook on 2020.09.07
 */
public interface CommentService {

    @GET("/comments")
    Single<List<Comment>> getComments(@Query("postId") long id);
}
