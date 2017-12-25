package com.android.predict.domain.interactor.usecase;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.predict.behavior.UserBehaviorHelper;
import com.android.predict.database.Database;
import com.android.predict.domain.excutor.DaoExecutor;
import com.android.predict.domain.excutor.PostExecutor;

import org.reactivestreams.Subscriber;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by orien on 2017/12/22.
 */

public class SaveUserBehavior extends UseCase<Intent, Object> {

    private final String TAG = this.getClass().getName();
    private final DaoExecutor mDaoExecutor;
    private final Database mDatabase;
    private final Context mContext;

    @Inject
    protected SaveUserBehavior(Context context, Executor threadExecutor, PostExecutor postExecutor,
                               DaoExecutor daoExecutor, Database database) {
        super(threadExecutor, postExecutor);
        mDaoExecutor = daoExecutor;
        mDatabase = database;
        mContext = context;
    }

    @Override
    protected Flowable<Object> buildUseCaseFlowable(Intent intent) {
        return new Flowable<Object>() {
            @Override
            protected void subscribeActual(Subscriber<? super Object> subscriber) {
                saveUserBehavior(intent);
                subscriber.onComplete();
            }
        }.subscribeOn(mDaoExecutor.getScheduler());
    }

    private void saveUserBehavior(Intent intent) {
        UserBehaviorHelper.saveUserClickData(mContext, intent, mDatabase);
    }

    @Override
    protected DisposableSubscriber<? super Object> buildSubscriber() {
        return new DisposableSubscriber<Object>() {
            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {
                Log.w(TAG, "finish save user behavior");
            }
        };
    }
}
