package jetpack.sample.app.di;

import androidx.lifecycle.ViewModel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import dagger.MapKey;

/**
 * Created by jongkook on 2020.09.02
 * .
 * <MapKey>
 * Dagger의 멀티바인딩을 이용해 여러 모듈에 있는 같은 타입의 객체를 하나의 Set 또는 Map에 관리할 수 있다.
 * 기본적으로 제공하는 키가 아닌 사용자가 직접 키를 정의할 수 있다. @MapKey를 통해 사용자 정의키 선언한다.
 */
@Retention(RetentionPolicy.RUNTIME)
@MapKey
public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}
