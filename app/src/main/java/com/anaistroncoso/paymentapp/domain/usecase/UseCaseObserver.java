package com.anaistroncoso.paymentapp.domain.usecase;

import io.reactivex.observers.DisposableObserver;

public abstract class UseCaseObserver<V, T> extends DisposableObserver<T> {

    V v;

    public void attachView(V v) {
        this.v = v;
    }

    protected V getView() {
        return v;
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onNext(T t) {
    }
}