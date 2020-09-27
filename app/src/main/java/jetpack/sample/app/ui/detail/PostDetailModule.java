package jetpack.sample.app.ui.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import dagger.Module;
import dagger.Provides;
import jetpack.sample.app.databinding.FragmentPostDetailBinding;
import jetpack.sample.app.di.AppContext;
import jetpack.sample.app.di.FragmentScope;

/**
 * Created by jongkook on 2020.09.19
 */
@Module
public class PostDetailModule {

    @Provides
    @FragmentScope
    public FragmentPostDetailBinding provideBinding(@AppContext Context context) {
        return FragmentPostDetailBinding.inflate(LayoutInflater.from(context), null, false);
    }

    @Provides
    @FragmentScope
    public LinearLayoutManager provideLinearLayoutManager(@AppContext Context context) {
        return new LinearLayoutManager(context) {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
            }
        };
    }

    @Provides
    @FragmentScope
    public NavController provideNavController(PostDetailFragment fragment) {
        return NavHostFragment.findNavController(fragment);
    }
}
