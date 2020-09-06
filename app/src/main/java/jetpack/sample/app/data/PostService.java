package jetpack.sample.app.data;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

/**
 * Created by jongkook on 2020.09.07
 */
public interface PostService {
    /**
     * 값을 한 개만 받을 때는 Single, 값을 안받는 경우는 Completable
     * https://medium.com/banksalad/migrate-from-rxjava1-to-rxjava2-3aea3ff9051c
     */
    @GET("/posts")
    Single<List<Post>> getPosts();
}
