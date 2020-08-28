package jetpack.sample.app.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by jongkook on 2020.08.28
 * .
 * @Scope
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScope {
    //
}
