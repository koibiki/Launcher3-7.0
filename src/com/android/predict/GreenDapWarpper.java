package com.android.predict;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * Created by chengli on 17-12-26.
 */

public class GreenDapWarpper extends ContextWrapper {

    public GreenDapWarpper(Context base) {
        super(base);
    }

    @Override
    public File getDatabasePath(String name) {

        String dbDir = Environment.getExternalStorageDirectory().getAbsolutePath() +
                File.separator + "Launcher" + File.separator + "database";
        String dbPath = dbDir + File.separator + name;

        File dirFile = new File(dbDir);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        boolean isFileCreateSuccess = false;

        File dbFile = new File(dbPath);
        if (!dbFile.exists()) {
            try {
                isFileCreateSuccess = dbFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            isFileCreateSuccess = true;
        if (isFileCreateSuccess)
            return dbFile;
        else
            return super.getDatabasePath(name);

    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory,
                                               DatabaseErrorHandler errorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
    }
}
