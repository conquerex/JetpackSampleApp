package jetpack.sample.app;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import jetpack.sample.app.di.DaggerAppComponent;
import timber.log.Timber;

/**
 * Created by jongkook on 2020.09.01
 */
public class App extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        // 로그용 Timber 설정
        Timber.plant(new Timber.DebugTree());
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        // AppComponent 설정이 끝난 뒤,
        // 컴파일 타임에 DaggerAppComponent가 생성된다.
        // todo : AppComponent 설정 후
        return DaggerAppComponent.factory().create(this);
    }
}
