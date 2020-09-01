package jetpack.sample.app.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import jetpack.sample.app.App;

/**
 * Created by jongkook on 2020.09.01
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class, // dagger.android 사용을 위한 설정
        ActivityModule.class, // 액티비티 스코프 모
        AppModule.class // 애플리케이션 스코프 모듈

})
public interface AppComponent extends AndroidInjector<App> {
    @Component.Factory
    abstract class Factory implements AndroidInjector.Factory<App> {
        //
    }
}
