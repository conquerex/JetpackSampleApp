package jetpack.sample.app;

import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;
import jetpack.sample.app.databinding.ActivityMainBinding;
import jetpack.sample.app.util.SingleLiveEvent;

// 멤버 인젝션을 하도록 DaggerAppCompatActivity를 상속한다.
public class MainActivity extends DaggerAppCompatActivity {

    // Lazy 인젝션 이유
    // 액티비티 생성이 끝나기 전에 setContentView()가 호출되면 안되기 때문
    @Inject
    Lazy<ActivityMainBinding> binding;

    @Inject
    @Named("errorEvent")
    SingleLiveEvent<Throwable> errorEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 이 액티비티를 LifecycleOwner로 설정하며,
        // 생명주기에 안전하게 데이터 바인딩을 할 수 있도록 한다.
        binding.get().setLifecycleOwner(this);

        errorEvent.observe(this, this::showErrorToast);
    }

    private void showErrorToast(Throwable throwable) {
        throwable.printStackTrace();
        showToast(throwable.getMessage());
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}