package jetpack.sample.app.ui.post;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import jetpack.sample.app.R;

/**
 * 현 시점에서는 Navigation Component에 Fragment가 등록되어 있지 않아서 에러가 발생
 * java.lang.RuntimeException:
 * Unable to start activity ComponentInfo{jetpack.sample.app/jetpack.sample.app.MainActivity}:
 * android.view.InflateException:
 * Binary XML file line #11: Binary XML file line #11:
 * Error inflating class androidx.fragment.app.FragmentContainerView
 */
public class PostFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post, container, false);
    }
}