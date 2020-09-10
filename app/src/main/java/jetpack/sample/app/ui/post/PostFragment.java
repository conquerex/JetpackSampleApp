package jetpack.sample.app.ui.post;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import jetpack.sample.app.R;
import jetpack.sample.app.databinding.FragmentPostBinding;
import jetpack.sample.app.di.AppViewModelFactory;

/**
 * 현 시점에서는 Navigation Component에 Fragment가 등록되어 있지 않아서 에러가 발생
 * java.lang.RuntimeException:
 * Unable to start activity ComponentInfo{jetpack.sample.app/jetpack.sample.app.MainActivity}:
 * android.view.InflateException:
 * Binary XML file line #11: Binary XML file line #11:
 * Error inflating class androidx.fragment.app.FragmentContainerView
 */
public class PostFragment extends DaggerFragment {

    /**
     * 오브젝트 그래프로부터 멤버 인젝션
     */
    // PostModule
    @Inject
    FragmentPostBinding binding;
    // ViewModelModule
    @Inject
    AppViewModelFactory viewModelFactory;

    PostViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ViewModel 객체를 요청
        viewModel = new ViewModelProvider(this, viewModelFactory).get(PostViewModel.class);
        if (savedInstanceState == null) {
            // 데이터 요청, 프래그먼트가 재생성되었을 때는 요청하지 않는다.
            viewModel.loadPosts();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_post, container, false);
        return binding.getRoot();
    }
}