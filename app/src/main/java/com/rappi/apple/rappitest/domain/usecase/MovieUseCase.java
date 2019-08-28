package com.rappi.apple.rappitest.domain.usecase;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

abstract class MovieUseCase<T, Params> {

        private final CompositeDisposable disposable;
        abstract Observable<T> buildUseCaseObservable(Params params);


    MovieUseCase() {
            this.disposable = new CompositeDisposable();
        }

        public void execute(DisposableObserver<T> observer, Params params){
            final Observable<T> observable = this.buildUseCaseObservable(params)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());

            addDisposable(observable.subscribeWith(observer));

        }



        public void dispose() {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }

        private void addDisposable(Disposable disposable) {
            this.disposable.add(disposable);
        }

}
