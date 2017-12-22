package com.android.predict.database;

import android.content.Context;
import android.util.Log;

import com.android.predict.dao.AppType;
import com.android.predict.dao.AppTypeDao;
import com.android.predict.dao.DaoMaster;
import com.android.predict.dao.DaoSession;
import com.android.predict.dao.User;
import com.android.predict.dao.UserDao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Created by orien on 2017/12/12.
 */
@Singleton
public class GreenDaoInstance implements Database {

    private final String TAG = "GreenDaoInstance";

    private static DaoSession mDaoSession;

    @Inject
    public GreenDaoInstance(Context context) {
        Log.w(TAG, "init the green dao");
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "user.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        mDaoSession = daoMaster.newSession();
    }

    private UserDao getUserDao() {
        return mDaoSession.getUserDao();
    }

    private AppTypeDao getAppTypeDao() {
        return mDaoSession.getAppTypeDao();
    }

    @Override
    public void insertUserBehavior(User user) {
        Log.w(TAG, "insertUserBehavior user " + user.getPackageName() + "   " + user.getDate()
                + " iswif:" + user.getWifiConnect() + "  ismobile:" + user.getMobileConnect()
                + "  latitude:" + user.getLatitude() + "    longtitude:" + user.getLongtitude());
        getUserDao().insertOrReplace(user);
    }

    @Override
    public void insertAppType(AppType appType) {
        getAppTypeDao().insertOrReplace(appType);
    }

    @Override
    public void updateAppTypes(List<AppType> appTypes) {
        for (AppType appType : appTypes) {
            getAppTypeDao().update(appType);
        }
    }

    @Override
    public void updateAppType(AppType appType) {
        getAppTypeDao().update(appType);
    }

    @Override
    public List<AppType> getAllAppType() {
        return getAppTypeDao().loadAll();
    }


}
