package com.android.predict.database;

import android.content.Context;
import android.util.Log;

import com.android.predict.dao.AppType;
import com.android.predict.dao.AppTypeDao;
import com.android.predict.dao.DaoMaster;
import com.android.predict.dao.DaoSession;
import com.android.predict.dao.User;
import com.android.predict.dao.UserDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Created by orien on 2017/12/12.
 */
@Singleton
public class GreenDaoInstance implements Database {

    private final String TAG = this.getClass().getName();

    private DaoSession mDaoSession;
    private Map<String, AppType> mTypeMap;

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
    public List<User> getAllUserBehavior(long startTime) {
        if (startTime > 0) {
            return getUserDao().queryBuilder().where(UserDao.Properties.Date.ge(startTime)).build().list();
        } else {
            return getUserDao().loadAll();
        }
    }

    @Override
    public void insertAppType(AppType appType) {
        getAppTypeDao().insertOrReplace(appType);
    }

    @Override
    public List<AppType> getAllAppType() {
        return getAppTypeDao().loadAll();
    }

    @Override
    public synchronized Map<String, AppType> getAllAppTypeMap() {
        if (mTypeMap == null) {
            List<AppType> appTypes = getAllAppType();
            mTypeMap = new HashMap<>();
            for (AppType appType : appTypes) {
                mTypeMap.put(appType.getPackageName(), appType);
            }
        }
        return mTypeMap;
    }

    @Override
    public synchronized void updateAppType(AppType appType) {
        if (mTypeMap == null) {
            mTypeMap = new HashMap<>();
        }
        mTypeMap.put(appType.getPackageName(), appType);
        getAppTypeDao().insertOrReplace(appType);
    }

    @Override
    public void deleteAppType(AppType appType) {
        getAppTypeDao().delete(appType);
    }

}
