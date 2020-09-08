package jetpack.sample.app.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import jetpack.sample.app.ui.post.PostViewModel;

/**
 * Created by jongkook on 2020.09.02
 * .
 * ViewModel과 관련된 내용을 오브젝트 그래프로 관리
 */
@Module
public abstract class ViewModelModule {
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory factory);

    // 오브젝트 그래프에 멀티 바인딩하도록 ViewModelModule에 다음과 같은 내용을 추가
    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel.class)
    abstract ViewModel bindsPostViewModel(PostViewModel viewModel);
}
