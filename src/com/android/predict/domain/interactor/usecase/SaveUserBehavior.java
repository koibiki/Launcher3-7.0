package com.android.predict.domain.interactor.usecase;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import com.android.predict.AppTypeInfo;
import com.android.predict.behavior.UserBehaviorHelper;
import com.android.predict.dao.AppDaoHelper;
import com.android.predict.dao.AppType;
import com.android.predict.database.Database;
import com.android.predict.domain.excutor.PostExecutionThread;

import org.reactivestreams.Subscriber;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by orien on 2017/12/22.
 */

public class SaveUserBehavior extends UseCase<Intent, Object> {

    private final String TAG = this.getClass().getName();
    private final Database mDatabase;
    private final Context mContext;

    @Inject
    protected SaveUserBehavior(Context context, Executor threadExecutor, PostExecutionThread postExecutionThread, Database database) {
        super(threadExecutor, postExecutionThread);
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
        };
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
