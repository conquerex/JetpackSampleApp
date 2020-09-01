package jetpack.sample.app.util;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.concurrent.atomic.AtomicBoolean;

import timber.log.Timber;

/**
 * Created by jongkook on 2020.09.01
 * .
 * LiveData를 이용하다보면, View의 재활성화 (start나 resume 상태로 재진입)가 되면서 LiveData가 observe를 호출하여,
 * 불필요한 Observer Event까지 일어나는 경우가 있습니다.
 * 이를 방지하기 위해 기존 LiveData를 상속하여 만들어낸 것이 SingleLiveEvent입니다.
 */
public class SingleLiveEvent<T> extends MutableLiveData<T> {

    /**
     * 멀티쓰레딩 환경에서 동시성을 보장하는 AtomicBoolean.
     * false로 초기화되어 있음
     */
    private final AtomicBoolean mPending = new AtomicBoolean(false);

    /**
     * View(Activity or Fragment 등 LifeCycleOwner)가 활성화 상태가 되거나
     * setValue로 값이 바뀌었을 때 호출되는 observe 함수.
     * pending.compareAndSet(true, false)라는 것은, 위의 pending 변수가
     * true면 if문 내의 로직을 처리하고 false로 바꾼다는 것이다.
     *
     * 아래의 setValue를 통해서만 pending값이 true로 바뀌기 때문에,
     * Configuration Changed가 일어나도 pending값은 false이기 때문에 observe가
     * 데이터를 전달하지 않는다!
     */
    @MainThread
    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
        if (hasActiveObservers()) {
            Timber.w("여러 Observer가 존재하지만, 단 하나만 알림을 받을 수 있다.");
        }

        super.observe(owner, t -> {
            // compareAndSet(boolean expect, boolean update)
            // 현재 값이 expect와 같을 경우 true, 그렇지 않을 경우 false를 리턴
            if (mPending.compareAndSet(true, false)) {
                observer.onChanged(t);
            }
        });
    }

    /**
     * LiveData로써 들고있는 데이터의 값을 변경하는 함수.
     * 여기서는 pending(AtomicBoolean)의 변수는 true로 바꾸어
     * observe내의 if문을 처리할 수 있도록 하였음.
     */
    @MainThread
    @Override
    public void setValue(T value) {
        mPending.set(true);
        super.setValue(value);
    }

    /**
     * 데이터의 속성을 지정해주지 않아도 call만으로 setValue를 호출 가능
     */
    @MainThread
    public void call() {
        setValue(null);
    }
}
