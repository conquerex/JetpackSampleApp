package jetpack.sample.app.ui.post;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

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
}
