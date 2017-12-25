package com.android.predict.domain.interactor.usecase;

import android.support.annotation.Nullable;

import com.android.predict.domain.excutor.PostExecutor;

import java.util.concurrent.Executor;


import io.reactivex.Flowable;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by chengli on 17-12-22.
 */

public abstract class UseCase<IN, OUT> {

    private final PostExecutor postExecutor;

    private DisposableSubscriber<? super OUT> mSubscribe;

    protected UseCase( Executor threadExecutor,PostExecutor postExecutor) {
        this.postExecutor = postExecutor;
    }

    protected abstract Flowable<OUT> buildUseCaseFlowable(IN in);

    protected abstract DisposableSubscriber<? super OUT> buildSubscriber();

    public synchronized void execute(@Nullable IN in) {
        mSubscribe = this.buildSubscriber();
        this.buildUseCaseFlowable(in)
                .observeOn(postExecutor.getScheduler())
                .subscribe(mSubscribe);
    }

    public synchronized void unsubscribe() {
        if (mSubscribe != null && !mSubscribe.isDisposed()) {
            mSubscribe.dispose();
        }
    }
}