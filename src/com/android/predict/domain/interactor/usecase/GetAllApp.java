package com.android.predict.domain.interactor.usecase;

import android.content.Context;
import android.content.Intent;

import com.android.launcher3.AppInfo;
import com.android.launcher3.LauncherAppState;
import com.android.predict.database.Database;
import com.android.predict.domain.excutor.DaoExecutor;
import com.android.predict.model.AppTypeInfo;
import com.android.predict.Constants;
import com.android.predict.database.AppDaoHelper;
import com.android.predict.domain.excutor.PostExecutor;
import com.android.predict.presentation.presenter.AppTypeContact;
import com.android.predict.utils.MillsRecordUtils;

import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;


import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by orien on 2017/12/22.
 */

public class GetAllApp extends UseCase<Object, List<AppTypeInfo>> {

    private final String TAG = this.getClass().getName();
    private Context mContext;
    private DaoExecutor mGreenDaoExecutor;
    Executor mThreadExecutor;
    private AppTypeContact.View mView;
    private Intent mIntent;
    private Database mDatabase;

    @Inject
    public GetAllApp(Context context, Executor threadExecutor, PostExecutor postExecutor,
                     DaoExecutor greenDaoExecutor,
                     AppTypeContact.View view,
                     Intent intent, Database database) {
        super(threadExecutor,postExecutor);
        mContext = context;
        mGreenDaoExecutor = greenDaoExecutor;
        mThreadExecutor = threadExecutor;
        mView = view;
        mIntent = intent;
        mDatabase = database;
    }


    @Override
    protected Flowable<List<AppTypeInfo>> buildUseCaseFlowable(Object o) {

        Flowable<Map<String, AppTypeInfo>> getDataFromDao =
                new Flowable<Map<String, AppTypeInfo>>() {
                    @Override
                    protected void subscribeActual(Subscriber<? super Map<String, AppTypeInfo>> subscriber) {
                        MillsRecordUtils.startRecord(Thread.currentThread().getName());

                        Map<String, AppTypeInfo> typeInfoMap = AppDaoHelper.getAppTypeInfos(mContext, mDatabase);

                        MillsRecordUtils.print(Thread.currentThread().getName(), TAG, "get data from dao");

                        subscriber.onNext(typeInfoMap);
                        subscriber.onComplete();
                    }
                };
        return getDataFromDao
                .subscribeOn(mGreenDaoExecutor.getScheduler())
                .observeOn(Schedulers.computation())
                .map(typeInfoMap -> {
                    MillsRecordUtils.startRecord(Thread.currentThread().getName());

                    int typePosition = mIntent.getIntExtra(Constants.TYPE_POSITION, 0);
                    List<AppInfo> allAppsList = LauncherAppState.getInstance().getModel().getBgAllAppsList().data;

                    List<String> packageList = new ArrayList<>();

                    for (AppInfo appInfo : allAppsList) {
                        String packageName = appInfo.componentName.getPackageName();
                        if (packageName.equals(mContext.getPackageName())) {
                            continue;
                        }
                        AppTypeInfo appTypeInfo = typeInfoMap.get(packageName);
                        if (appTypeInfo == null) {
                            appTypeInfo = new AppTypeInfo();
                            appTypeInfo.setPackageName(packageName);
                            typeInfoMap.put(packageName, appTypeInfo);
                        }
                        appTypeInfo.setCurrentPosition(typePosition);
                        appTypeInfo.setAppName(appInfo.title.toString());
                        appTypeInfo.setIconBitmap(appInfo.iconBitmap);
                        packageList.add(packageName);
                    }

                    Set<String> strings = typeInfoMap.keySet();
                    Iterator<String> iterator = strings.iterator();
                    while (iterator.hasNext()) {
                        String next = iterator.next();
                        if (!packageList.contains(next)) {
                            AppDaoHelper.deleteAppType(mDatabase, typeInfoMap.get(next));
                            iterator.remove();
                        }
                    }
                    List<AppTypeInfo> appTypeInfos = new ArrayList<>(typeInfoMap.values());
                    Collections.sort(appTypeInfos);

                    MillsRecordUtils.print(Thread.currentThread().getName(), TAG, "map to appTypeInfos");
                    return appTypeInfos;
                });
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
                e.printStackTrace();
            }

            @Override
            public void onComplete() {

            }
        };
    }


}
