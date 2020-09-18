package jetpack.sample.app.ui.post;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import dagger.Module;
import dagger.Provides;
import jetpack.sample.app.databinding.FragmentPostBinding;
import jetpack.sample.app.di.AppContext;
import jetpack.sample.app.di.FragmentScope;

/**
 * Created by jongkook on 2020.09.08
 */
@Module
public class PostModule {
    // 데이터 바인딩 클래스 제공 --> PostFragment
    @Provides
    @FragmentScope
    FragmentPostBinding provideBinding(@AppContext Context context) {
        return FragmentPostBinding.inflate(LayoutInflater.from(context), null, false);
    }

    // RecyclerView용 레이아웃 매니저
    @Provides
    @FragmentScope
    LinearLayoutManager provideLinearManager(@AppContext Context context) {
        return new LinearLayoutManager(context) {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };
    }

    /**
     * Caused by: java.lang.IllegalArgumentException: navigation destination jetpack.sample.app:layout/fragment_post is not a direct child of this NavGraph
     * navController가 처리되어 있지 않기 때문
     */

    // Navigation 컴포넌트에서 목적지 간 이동을 담당하는 NavController
    @Provides
    @FragmentScope
    NavController provideNavController(PostFragment fragment) {
        return NavHostFragment.findNavController(fragment);
    }
}
