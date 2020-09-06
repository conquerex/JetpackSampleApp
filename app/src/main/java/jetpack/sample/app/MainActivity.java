package jetpack.sample.app;

import android.os.Bundle;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;
import jetpack.sample.app.databinding.ActivityMainBinding;

// 멤버 인젝션을 하도록 DaggerAppCompatActivity를 상속한다.
public class MainActivity extends DaggerAppCompatActivity {

    // Lazy 인젝션 이유
    // 액티비티 생성이 끝나기 전에 setContentView()가 호출되면 안되기 때문
    @Inject
    Lazy<ActivityMainBinding> binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 이 액티비티를 LifecycleOwner로 설정하며,
        // 생명주기에 안전하게 데이터 바인딩을 할 수 있도록 한다.
        binding.get().setLifecycleOwner(this);
    }
}