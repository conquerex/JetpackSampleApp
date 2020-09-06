package jetpack.sample.app.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import jetpack.sample.app.MainActivity;
import jetpack.sample.app.ui.MainModule;

/**
 * Created by jongkook on 2020.09.01
 */
@Module
public abstract class ActivityModule {
    /**
     * MainActivity를 위한 서브 컴포넌트를 정의한다.
     * .
     * <ContributesAndroidInjector>
     * SubComponent들의 선언을 대체.
     * SubComponent와 SubComponent.Factory가 메서드가 없고, 부모(상속)이 없을 경우 사용
     * 아래 경우 MainActivity <-- MainComponent <-- MainModule
     * (https://black-jin0427.tistory.com/168)
     */
    @ActivityScope
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();
}
