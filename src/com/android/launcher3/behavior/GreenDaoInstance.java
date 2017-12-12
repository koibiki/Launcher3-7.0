package com.android.launcher3.behavior;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import com.android.launcher3.LauncherApplication;
import com.android.launcher3.database.DaoMaster;
import com.android.launcher3.database.DaoSession;
import com.android.launcher3.database.User;
import com.android.launcher3.database.UserDao;

import java.security.PublicKey;

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
        Log.w(TAG, "init the green dao");
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "user.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        mDaoSession = daoMaster.newSession();
        mHandler = new Handler(thread.getLooper());
    }

    public static GreenDaoInstance getInstance() {
        return INSTANCE;
    }

    public UserDao getUserDao() {
        return mDaoSession.getUserDao();
    }

    public void insert(User user) {
        Log.w(TAG, "insert user " + user.getPackageName() + "   " + user.getDate()
                + " iswif:" + user.getWifiConnect() + "  ismobile:" + user.getMobileConnect()
                + "  inworkspace:" + user.getInWorkspace()
                + "  latitude:" + user.getLatitude() + "    longtitude:" + user.getLongtitude());
        mHandler.post(() -> getUserDao().insert(user));
    }

}
