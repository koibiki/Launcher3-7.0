package com.android.launcher3;

import android.os.Environment;
import android.os.SystemClock;
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
        long begin = SystemClock.currentThreadTimeMillis();
        String stringFromJNI = stringFromJNI();
        Log.w(TAG, "TESTJNI :" + stringFromJNI + "   " + Thread.currentThread().getName());
        String root = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Launcher/model";
        String path = root + "/train1.conf";
        File file = new File(path);
        Log.w(TAG, "train File :" + file.exists());
        String trainConfig = "config=" + path;
        String outputModelPath = "output_model=" + root + "/output_model.txt";
        trainModel(path, trainConfig, outputModelPath);
        Log.w(TAG, "spent time  " + (SystemClock.currentThreadTimeMillis() - begin) / 1000);
    }

    public static native String stringFromJNI();

    public static native void trainModel(String path, String config, String outputModelPath);
}

