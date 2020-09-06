package jetpack.sample.app.ui;

import android.content.Context;

import androidx.databinding.DataBindingUtil;

import dagger.Module;
import dagger.Provides;
import jetpack.sample.app.MainActivity;
import jetpack.sample.app.R;
import jetpack.sample.app.databinding.ActivityMainBinding;
import jetpack.sample.app.di.ActivityContext;
import jetpack.sample.app.di.ActivityScope;

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
}
