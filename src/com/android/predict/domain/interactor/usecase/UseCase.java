package com.android.predict.domain.interactor.usecase;

import android.support.annotation.Nullable;

import com.android.predict.domain.excutor.PostExecutionThread;

import java.util.concurrent.Executor;


import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by chengli on 17-12-22.
 */

public abstract class UseCase<IN, OUT> {

    private final Executor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    private DisposableSubscriber<? super OUT> mSubscribe;

    protected UseCase(Executor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    protected abstract Flowable<OUT> buildUseCaseFlowable(IN in);

    protected abstract DisposableSubscriber<? super OUT> buildSubscriber();

    public synchronized void execute(@Nullable IN in) {
        mSubscribe = this.buildSubscriber();
        this.buildUseCaseFlowable(in)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(mSubscribe);
    }

    public synchronized void unsubscribe() {
        if (mSubscribe != null && !mSubscribe.isDisposed()) {
            mSubscribe.dispose();
        }
    }
}