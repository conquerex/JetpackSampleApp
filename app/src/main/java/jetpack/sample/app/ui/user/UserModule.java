package jetpack.sample.app.ui.user;

import android.content.Context;
import android.view.LayoutInflater;

import dagger.Module;
import dagger.Provides;
import jetpack.sample.app.databinding.FragmentUserBinding;
import jetpack.sample.app.di.ActivityContext;
import jetpack.sample.app.di.FragmentScope;

/**
 * Created by jongkook on 2020.09.28
 */
@Module
public class UserModule {
    @Provides
    @FragmentScope
    FragmentUserBinding provideBinding(@ActivityContext Context context) {
        return FragmentUserBinding.inflate(LayoutInflater.from(context));
    }
}
