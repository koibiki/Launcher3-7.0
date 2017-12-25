package com.android.predict.domain.interactor.usecase;

import android.util.Log;

import com.android.predict.dao.AppType;
import com.android.predict.dao.User;
import com.android.predict.database.Database;
import com.android.predict.domain.excutor.PostExecutor;
import com.android.predict.model.AppTypeInfo;

import org.reactivestreams.Subscriber;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by orien on 2017/12/22.
 */

public class TrainModel extends UseCase<List<AppTypeInfo>, Object> {
    private final String TAG = this.getClass().getName();
    private final Database mDatabase;

    @Inject
    protected TrainModel(Executor threadExecutor, PostExecutor postExecutor, Database database) {
        super(threadExecutor, postExecutor);
        mDatabase = database;
    }

    @Override
    protected Flowable<Object> buildUseCaseFlowable(List<AppTypeInfo> appTypeInfos) {
        return new Flowable<Object>() {
            @Override
            protected void subscribeActual(Subscriber<? super Object> subscriber) {
                createTrainData();

                subscriber.onComplete();
            }
        };
    }

    private void createTrainData() {
        List<AppType> allAppType = mDatabase.getAllAppType();
        List<User> allUserBehavior = mDatabase.getAllUserBehavior(0);

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
                Log.w(TAG, "finish train model");
            }
        };
    }
}
