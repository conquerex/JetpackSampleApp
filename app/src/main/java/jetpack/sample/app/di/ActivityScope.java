package jetpack.sample.app.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by jongkook on 2020.08.28
 * .
 * @Scope
 * 컴포넌트의 범위를 지정
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
    //
}
