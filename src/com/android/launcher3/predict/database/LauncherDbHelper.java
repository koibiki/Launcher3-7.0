package com.android.launcher3.predict.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * Created by chengli on 17-12-21.
 */

public class LauncherDbHelper extends DaoMaster.DevOpenHelper {
    public LauncherDbHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}
