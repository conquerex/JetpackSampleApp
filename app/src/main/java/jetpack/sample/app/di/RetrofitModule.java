package jetpack.sample.app.di;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import jetpack.sample.app.data.CommentService;
import jetpack.sample.app.data.PostService;
import jetpack.sample.app.data.UserService;
import retrofit2.Retrofit;

/**
 * Created by jongkook on 2020.09.07
 */
@Module
public class RetrofitModule {

    /**
     * <Reusable>
     * https://www.charlezz.com/?p=1289
     */
    @Provides
    @Reusable
    PostService providePostService(Retrofit retrofit) {
        return retrofit.create(PostService.class);
    }

    @Provides
    @Reusable
    CommentService provideCommentService(Retrofit retrofit) {
        return retrofit.create(CommentService.class);
    }

    @Provides
    @Reusable
    UserService provideUserService(Retrofit retrofit) {
        return retrofit.create(UserService.class);
    }
}
