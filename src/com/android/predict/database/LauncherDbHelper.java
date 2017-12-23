package com.android.predict.database;

import android.content.Context;

import com.android.predict.dao.DaoMaster;

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
