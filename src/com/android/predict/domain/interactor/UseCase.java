package com.android.predict.domain.interactor;

import com.android.predict.domain.excutor.PostExecutionThread;

import org.reactivestreams.Subscription;

import io.reactivex.Observer;

import java.util.concurrent.Executor;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chengli on 17-12-22.
 */

public abstract class UseCase<T> {

    private final Executor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    private Subscription subscription;
    private Observable<T> tObservable;

    protected UseCase(Executor threadExecutor,
                      PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }


    protected abstract Observable<T> buildUseCaseObservable();


    public void execute(Observer<T> observer) {
        tObservable = this.buildUseCaseObservable();
        tObservable
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(observer);
    }


    public void unsubscribe() {
//        tObservable.
//        if (!subscription.isUnsubscribed()) {
//            subscription.unsubscribe();
//        }
    }
}