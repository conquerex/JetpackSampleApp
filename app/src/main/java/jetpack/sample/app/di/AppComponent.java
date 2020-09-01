package jetpack.sample.app.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import jetpack.sample.app.App;

/**
 * Created by jongkook on 2020.09.01
 * .
 * <AndroidInjector>
 * 안드로이드 프레임워크 클래스들(Application, Activity, Fragment, Service, BroadcastReceiver, ContentProvider)을 주입시켜주는 클래스
 * App을 주입하기 위해 AndroidInjector<App>을 구현하는 @Component를 작성하고
 * AndroidInjector.Factory<App>을 구현하는 @Component.Factory를 작성합니다.
 * .
 * <Context 주입방법 3가지 - https://jaejong.tistory.com/144>
 * context 객체는 직접 new생성자로 만들 수 있는게 아니라, 안드로이드 시스템에서 만들어주는 객체이기 때문에
 * 클래스에서 context를 사용하기 위해서는 이 값을 파라메터를 통해 전달받아야 합니다.
 * context를 dagger2 그래프에 주입하는 방법을 찾아본 결과 3가지로 나눠서 보겠습니다.
 *   1. 생성자 인수가있는 Module
 *   2. @Component.Builder
 *   3. @Component.Factory
 * .
 * <Component.Factory, Builder보다 나은 점>
 * 각 의존성에 대해 메소드를 새로 추가하지 않기 때문에, Component 생성 시 긴 체인이 없으며
 * 메서드 수는 모든 경우에 동일하게 유지됩니다. (create() 하나로 구성)
 * 각 종속성은 함수에 매개변수를 추가하는 방식으로, 종속성을 전달하지 않은 경우에는
 * 런타임 예외가 아닌 컴파일 시간에 오류가 발생합니다 (빠른 오류처리)
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
