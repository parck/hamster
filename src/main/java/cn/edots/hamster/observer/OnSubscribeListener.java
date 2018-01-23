package cn.edots.hamster.observer;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class OnSubscribeListener<R> implements Observer<R> {

    public void onSubscribe(Disposable disposable) {

    }

    public void onNext(R r) {
        complete(true, r, null);
    }

    public void onError(Throwable throwable) {
        complete(false, null, throwable);
    }

    public void onComplete() {

    }

    public abstract void complete(boolean success, R result, Throwable throwable);
}
