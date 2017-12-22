package com.android.predict.domain.interactor.usecase;

import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import com.android.launcher3.AppInfo;
import com.android.launcher3.LauncherAppState;
import com.android.predict.AppTypeInfo;
import com.android.predict.Constants;
import com.android.predict.dao.AppDaoHelper;
import com.android.predict.dao.AppType;
import com.android.predict.database.Database;
import com.android.predict.domain.excutor.PostExecutionThread;
import com.android.predict.presentation.presenter.AppTypeContact;

import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by orien on 2017/12/22.
 */

public class GetAllApp extends UseCase<Object, List<AppTypeInfo>> {

    private final String TAG = this.getClass().getName();
    private AppTypeContact.View mView;
    private Intent mIntent;
    private Database mDatabase;

    @Inject
    public GetAllApp(Executor threadExecutor, PostExecutionThread postExecutionThread,
                     AppTypeContact.View view, Intent intent, Database database) {
        super(threadExecutor, postExecutionThread);
        mView = view;
        mIntent = intent;
        mDatabase = database;
    }

    @Override
    protected Flowable<List<AppTypeInfo>> buildUseCaseFlowable(Object o) {
        return new Flowable<List<AppTypeInfo>>() {

            @Override
            protected void subscribeActual(Subscriber<? super List<AppTypeInfo>> subscriber) {
                long l = SystemClock.currentThreadTimeMillis();
                int typePosition = mIntent.getIntExtra(Constants.TYPE_POSITION, 0);
                ArrayList<AppInfo> allAppsList = LauncherAppState.getInstance().getModel().getBgAllAppsList().data;
                Log.w(TAG, "allAppsList spent:" + (SystemClock.currentThreadTimeMillis() - l) + "    " + Thread.currentThread().getName());
                Map<String, AppType> typeMap = mDatabase.getAllAppTypeMap();
                Log.w(TAG, "getAllAppTypeMap spent:" + (SystemClock.currentThreadTimeMillis() - l));
                ArrayList<AppTypeInfo> appTypeInfos = new ArrayList<>();
                for (AppInfo appInfo : allAppsList) {
                    String packageName = appInfo.componentName.getPackageName();
                    AppType appType = typeMap.get(packageName);
                    if (appType == null) {
                        appType = new AppType();
                        appType.setPackageName(packageName);
                        typeMap.put(packageName, appType);
                    }
                    AppTypeInfo appTypeInfo = AppDaoHelper.transferAppTypeInfo(appType);
                    appTypeInfo.setCurrentPosition(typePosition);
                    appTypeInfo.setAppName(appInfo.title.toString());
                    appTypeInfo.setIconBitmap(appInfo.iconBitmap);
                    appTypeInfos.add(appTypeInfo);
                }
                Log.w(TAG, "transferAppTypeInfo spent:" + (SystemClock.currentThreadTimeMillis() - l));
                Collections.sort(appTypeInfos);
                Log.w(TAG, "sort all app spent:" + (SystemClock.currentThreadTimeMillis() - l));
                subscriber.onNext(appTypeInfos);
                subscriber.onComplete();
                Log.w(TAG, "get all app spent:" + (SystemClock.currentThreadTimeMillis() - l));
            }

        };
    }

    @Override
    protected DisposableSubscriber<? super List<AppTypeInfo>> buildSubscriber() {

        return new DisposableSubscriber<List<AppTypeInfo>>() {
            @Override
            public void onNext(List<AppTypeInfo> appTypeInfos) {
                mView.loadSuccess(appTypeInfos);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }


}
