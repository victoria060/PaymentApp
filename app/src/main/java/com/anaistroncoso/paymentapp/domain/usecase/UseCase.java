package com.anaistroncoso.paymentapp.domain.usecase;


import dagger.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<T> extends BaseUseCase<T>{

    public void execute(DisposableObserver<T> disposableObserver) {
        Preconditions.checkNotNull(disposableObserver);
        final Observable<T> observable = buildUseCaseObservable().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        DisposableObserver observer = observable.subscribeWith(disposableObserver);
        compositeDisposable.add(observer);
    }

    protected abstract Observable<T> buildUseCaseObservable();
}

