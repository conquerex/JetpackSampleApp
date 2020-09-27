package jetpack.sample.app.ui.post;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerFragment;
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

    @Inject
    PostAdapter adapter;
    @Inject
    LinearLayoutManager layoutManager;

    PostViewModel viewModel;

    // NavController의 멤버 인젝션을 위해 POSTModule에 프로바이드 메서드를 추가!!!!
    @Inject
    Lazy<NavController> navController;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Lifecycle Owner 등록
        binding.setLifecycleOwner(getViewLifecycleOwner());
        // RecyclerView Adapter 지정
        binding.recyclerView.setAdapter(adapter);
        // RecyclerView 레이아웃 매니저 지정
        binding.recyclerView.setLayoutManager(layoutManager);
        // 바인딩 클래스에 ViewModel 연결
        binding.setViewModel(viewModel);
        // ViewModel이 가진 게시 글 목록을 구독하여 Adapter에 반영
        viewModel.getLivePosts()
                .observe(getViewLifecycleOwner(), list -> adapter.setItems(list));

        // 게시 글이 클릭되었을 때 게시글 상세 화면 목적지로 이동
//        viewModel.getPostClickEvent()
//                .observe(getViewLifecycleOwner(),
//                        postItem -> navController.get().navigate(
//                                PostFragmentDirections.actionFragmentToPostDetailFragment(
//                                        postItem.getPost()
//                                )
//                        )
//                );
    }
}