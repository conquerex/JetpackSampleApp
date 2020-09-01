package jetpack.sample.app.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jetpack.sample.app.App;
import jetpack.sample.app.util.SingleLiveEvent;

/**
 * Created by jongkook on 2020.09.01
 */
@Module
public class AppModule {
    @Provides
    @Singleton
    Application provideApp(App app) {
        return app;
    }

    @Provides
    @Singleton
    @AppContext
    Context provideContext(App app) {
        return app;
    }

    // 앱의 오류 이벤트를 처리하는 SingleLiveEvent
    @Provides
    @Singleton
    @Named("errorEvent")
    SingleLiveEvent<Throwable> provideErrorEvent() {
        return new SingleLiveEvent<>();
    }
}