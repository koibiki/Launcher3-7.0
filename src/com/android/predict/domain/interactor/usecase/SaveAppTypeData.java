package com.android.predict.domain.interactor.usecase;

import android.os.SystemClock;
import android.util.Log;

import com.android.predict.AppTypeInfo;
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

public class SaveAppTypeData extends UseCase<List<AppTypeInfo>, Object> {

    private final Database mDatabase;

    @Inject
    protected SaveAppTypeData(Executor threadExecutor, PostExecutionThread postExecutionThread, Database database) {
        super(threadExecutor, postExecutionThread);
        mDatabase = database;
    }

    @Override
    protected Flowable<Object> buildUseCaseFlowable(List<AppTypeInfo> appTypeInfos) {
        return new Flowable<Object>() {
            @Override
            protected void subscribeActual(Subscriber<? super Object> subscriber) {
                saveAppTypeData(appTypeInfos);
                subscriber.onComplete();
            }
        };
    }

    private void saveAppTypeData(List<AppTypeInfo> appTypeInfos) {
        long l = SystemClock.currentThreadTimeMillis();
        for (AppTypeInfo appTypeInfo : appTypeInfos) {
            AppType appType = AppDaoHelper.transferApptype(appTypeInfo);
            mDatabase.updateAppType(appType);
        }
        Log.w("test", "saveAppTypeData spent:" + (SystemClock.currentThreadTimeMillis() - l) + "     " + Thread.currentThread().getName());
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
                Log.w("test", "finish save saveAppTypeData");
            }
        };
    }
}
