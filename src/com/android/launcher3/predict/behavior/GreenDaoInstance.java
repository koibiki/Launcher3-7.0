package com.android.launcher3.predict.behavior;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import com.android.launcher3.LauncherApplication;
import com.android.launcher3.predict.database.AppType;
import com.android.launcher3.predict.database.AppTypeDao;
import com.android.launcher3.predict.database.DaoMaster;
import com.android.launcher3.predict.database.DaoSession;
import com.android.launcher3.predict.database.User;
import com.android.launcher3.predict.database.UserDao;

import java.util.List;

/**
 * Created by orien on 2017/12/12.
 */

public class GreenDaoInstance {

    private static GreenDaoInstance INSTANCE;

    private final String TAG = "GreenDaoInstance";

    static {
        INSTANCE = new GreenDaoInstance(LauncherApplication.getInstance());
    }

    private static DaoSession mDaoSession;
    private final Handler mHandler;

    private GreenDaoInstance(Context context) {
        HandlerThread thread = new HandlerThread("green_dao");
        thread.start();
        mHandler = new Handler(thread.getLooper());
        Log.w(TAG, "init the green dao");
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "user.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        mDaoSession = daoMaster.newSession();
    }

    public static GreenDaoInstance getInstance() {
        return INSTANCE;
    }

    public UserDao getUserDao() {
        return mDaoSession.getUserDao();
    }

    public AppTypeDao getAppTypeDao() {
        return mDaoSession.getAppTypeDao();
    }

    public void insertUserBehavior(User user) {
        Log.w(TAG, "insertUserBehavior user " + user.getPackageName() + "   " + user.getDate()
                + " iswif:" + user.getWifiConnect() + "  ismobile:" + user.getMobileConnect()
                + "  latitude:" + user.getLatitude() + "    longtitude:" + user.getLongtitude());
        execute(() -> getUserDao().insert(user));
    }

    public void updateAppType(List<AppType> appTypes) {
        execute(() -> {
            for (AppType appType : appTypes) {
                getAppTypeDao().update(appType);
            }
        });
    }

    public void execute(Runnable runnable) {
        mHandler.post(runnable);
    }

}
