package jetpack.sample.app.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import jetpack.sample.app.ui.post.PostViewModel;

/**
 * Created by jongkook on 2020.09.02
 * .
 * ViewModel과 관련된 내용을 오브젝트 그래프로 관리
 */
@Module
public abstract class ViewModelModule {
    /**
     * <Dagger2와 ViewModel 설정>
     * 3. 단일의 ViewModelProvider.Factory 인스턴스를 오브젝트 그래프에서 관리하고
     *    Activity 또는 Fragment에 제공하여 ViewModelProvider로부터 ViewModel 인스턴스를 요청한다.
     * 4. 단일의 ViewModelProvider.Factory로 모든 ViewModel 서브 클래스를 생성해야 하므로,
     *    리플렉션과 멀티 바인딩으로 모든 ViewModel 타입을 생성하고 관리해야 한다.
     */
    // AppViewModelFactory, @Inject
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory factory);

    /**
     * 오브젝트 그래프에 멀티 바인딩하도록 ViewModelModule에 다음과 같은 내용을 추가
     * 메소드 내부에서 직접 인스턴스를 생성하지 않고 연결만 하는 경우에는 아래와 같이 Binds를 이용하여 추상화
     * .
     * <Binds>
     * @Provides 차이점 : 하나의 매개변수만. 매개 변수를 반환형으로 바인드. 더 효율적.
     *                  Module과 Module Factory를 거칠 필요가 없다.
     * https://medium.com/mobile-app-development-publication/dagger-2-binds-vs-provides-cbf3c10511b5
     * .
     * ViewModel 객체를 PostViewModel이란 객체에 바인딩 --> PostViewModel, @Inject
     * .
     * <Binds 사용조건>
     * 1. 매개변수로 쓰인 클래스(아래 경우 PostViewModel)에서 @Inject 혹은
     * 2. 매개변수를 반환하는 Provides 메서드가 있어야 한다.
     * https://jaejong.tistory.com/131
     * .
     * 멀티바인딩을 사용함에도 불구하고 컴포넌트에 바인딩된 객체를 반환하는 메서드가 없는 이유
     * - AndroidSupportInjectionModule 사용으로 인해 component에 별도의 inject 함수가 없음
     * - DaggerApplication, DaggerActivity 등으로 인해 module에서 제공되는 객체를 주입받을 수 있다.
     */
    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel.class)
    abstract ViewModel bindsPostViewModel(PostViewModel viewModel);
}
