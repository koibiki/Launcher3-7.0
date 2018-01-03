package com.android.predict.domain.interactor.usecase;

import android.os.SystemClock;
import android.util.Log;

import com.android.predict.domain.excutor.DaoExecutor;
import com.android.predict.domain.excutor.PostExecutor;
import com.android.predict.model.AppTypeInfo;
import com.android.predict.database.AppDaoHelper;
import com.android.predict.dao.AppType;
import com.android.predict.database.Database;
import com.android.predict.utils.MillsRecordUtils;

import org.reactivestreams.Subscriber;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by orien on 2017/12/22.
 */

public class SaveAppTypeData extends UseCase<List<AppTypeInfo>, Object> {
    private final String TAG = this.getClass().getName();
    private final DaoExecutor mDaoExecutor;
    private final Database mDatabase;

    @Inject
    protected SaveAppTypeData(Executor threadExecutor, PostExecutor postExecutor,
                              DaoExecutor daoExecutor, Database database) {
        super(threadExecutor, postExecutor);
        mDaoExecutor = daoExecutor;
        mDatabase = database;
    }

    @Override
    protected Flowable<Object> buildUseCaseFlowable(List<AppTypeInfo> appTypeInfos) {
        return new Flowable<Object>() {
            @Override
            protected void subscribeActual(Subscriber<? super Object> subscriber) {
                MillsRecordUtils.startRecord(Thread.currentThread().getName());
                saveAppTypeData(appTypeInfos);
                MillsRecordUtils.print(Thread.currentThread().getName(), TAG, "saveAppTypeData spent:");
                subscriber.onComplete();
            }
        }.subscribeOn(mDaoExecutor.getScheduler());
    }

    private void saveAppTypeData(List<AppTypeInfo> appTypeInfos) {
        Flowable.fromIterable(appTypeInfos)
                .map(AppDaoHelper::transferApptype)
                .subscribe(mDatabase::updateAppType);
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
                Log.w(TAG, "finish save saveAppTypeData");
            }
        };
    }
}
