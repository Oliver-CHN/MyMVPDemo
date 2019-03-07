package com.test.mymvpdemo.base;

import com.test.mymvpdemo.mvp.BaseCallback;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class ResponseSubscriber<T> implements Observer<T> {

    private BaseCallback callback;

    public ResponseSubscriber(BaseCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        callback.onError(e.getMessage());
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T t);

}
