package com.android.predict;

import android.content.Context;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

/**
 * Created by orien on 2017/12/13.
 */

public class TestJni {

    private static final String TAG = TestJni.class.getName();
    private static final String root = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Launcher/model";
    static {
        System.loadLibrary("native-lib");
    }

    public static void trainModel() {
        long begin = SystemClock.currentThreadTimeMillis();
        String stringFromJNI = stringFromJNI();
        Log.w(TAG, "TESTJNI :" + stringFromJNI + "   " + Thread.currentThread().getName());
        String path = root + "/train1.conf";
        File file = new File(path);
        Log.w(TAG, "train File :" + file.exists());
        String trainConfig = "config=" + path;
        String outputModelPath = "output_model=" + root + "/output_model.txt";
        trainModelJni(path, trainConfig, outputModelPath);
        String spentTime ="spent time  " + (SystemClock.currentThreadTimeMillis() - begin) / 1000;
        Log.w(TAG, spentTime);
    }

    public static void predict() {
        long begin = SystemClock.currentThreadTimeMillis();
        String path = root + "/predictJni.conf";
        String config = "config=" + path;
        predictJni(config);
        String spentTime ="spent time  " + (SystemClock.currentThreadTimeMillis() - begin) / 1000;
        Log.w(TAG, spentTime);
    }

    public static native String stringFromJNI();

    public static native void trainModelJni(String path, String config, String outputModelPath);

    public static native void predictJni(String config);
}

