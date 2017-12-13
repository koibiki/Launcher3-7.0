package com.android.launcher3;

import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * Created by orien on 2017/12/13.
 */

public class TestJni {

    private static final String TAG = TestJni.class.getName();

    static {
        System.loadLibrary("native-lib");
    }

    public static void testJni() {
        String stringFromJNI = stringFromJNI();
        Log.w(TAG, "TESTJNI :" + stringFromJNI);

        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Launcher/model/train.conf";
        File file = new File(path);
        Log.w(TAG, "train File :" + file.exists());
        String trainConfig = "config=" + path;
        trainModel(trainConfig);
    }

    public static native String stringFromJNI();

    public static native void trainModel(String path);
}

