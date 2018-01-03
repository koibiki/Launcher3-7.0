package com.android.predict;

import android.content.Context;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import com.android.predict.utils.MillsRecordUtils;

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

    public static void trainModel(int classNum) {
        MillsRecordUtils.startRecord(Thread.currentThread().getName());
        String path = root + "/train.conf";
        File file = new File(path);
        Log.w(TAG, "train File :" + file.exists());
        String trainConfig = "config=" + path;
        String classNumConfig = "num_class=" + classNum;
        trainModelJni(path, trainConfig,classNumConfig);
        MillsRecordUtils.print(Thread.currentThread().getName(),TAG,"train model");
    }

    public static void predict() {
        MillsRecordUtils.startRecord(Thread.currentThread().getName());
        String path = root + "/predict.conf";
        String config = "config=" + path;
        predictJni(config);
        MillsRecordUtils.print(Thread.currentThread().getName(),TAG,"train model");
    }

    public static native String stringFromJNI();

    public static native void trainModelJni(String path, String config,String classNum);

    public static native void predictJni(String config);
}

