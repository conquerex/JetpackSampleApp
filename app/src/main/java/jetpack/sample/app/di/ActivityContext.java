package jetpack.sample.app.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by jongkook on 2020.08.27
 * .
 * @Qualifier
 * 사용자 정의 고유 한정. 한정자 지정하기.
 * @Retention(RetentionPolicy.RUNTIME)
 * 어노테이션이 어느레벨까지 유지되는지를 결정짓는다.
 * 컴파일 이후에도 JVM에 의해 계속 참조가 가능. (리플렉션 사용)
 * @interface
 * 커스텀 어노테이션
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityContext {
    //
}
