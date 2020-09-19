package jetpack.sample.app.ui;

import android.content.Context;

import androidx.databinding.DataBindingUtil;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import jetpack.sample.app.MainActivity;
import jetpack.sample.app.R;
import jetpack.sample.app.databinding.ActivityMainBinding;
import jetpack.sample.app.di.ActivityContext;
import jetpack.sample.app.di.ActivityScope;
import jetpack.sample.app.di.FragmentScope;
import jetpack.sample.app.ui.post.PostFragment;
import jetpack.sample.app.ui.post.PostModule;

/**
 * Created by jongkook on 2020.09.03
 */
@Module
public abstract class MainModule {
    @Provides
    @ActivityScope
    static ActivityMainBinding provideBinding(MainActivity activity) {
        return DataBindingUtil.setContentView(activity, R.layout.activity_main);
    }

    @Provides
    @ActivityContext
    static Context provideContext(MainActivity activity) {
        return activity;
    }

    /**
     * <서브 컴포넌트 정의>
     * PostFragment에 멤버 인젝션의 필요 모듈을 정의하고 서브 컴포넌트로 연결해야.
     * PostModule을 정의하고 MainModule의 서브 컴포넌트로 선언
     */
    @FragmentScope
    @ContributesAndroidInjector(modules = PostModule.class)
    abstract PostFragment getPostFragment();
}
