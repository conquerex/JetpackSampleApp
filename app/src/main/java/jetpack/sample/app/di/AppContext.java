package jetpack.sample.app.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by jongkook on 2020.08.28
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface AppContext {
    //
}
