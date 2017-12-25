package com.android.predict.utils;

import android.os.SystemClock;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by orien on 2017/12/25.
 */

public class MillsRecordUtils {

    private static Map<String, MillsRecord> mMap;

    static {
        mMap = new HashMap<>();
    }


    static class MillsRecord {
        long start;

        MillsRecord() {
            start = SystemClock.currentThreadTimeMillis();
        }

        public void print(String thread, String tag, String prefix) {
            Log.w(tag, prefix + "   thread:" + thread + "   spent:" + (SystemClock.currentThreadTimeMillis() - start));
        }
    }

    public static void startRecord(String thread) {
        MillsRecord millsRecord = new MillsRecord();
        mMap.put(thread, millsRecord);
    }

    public static void print(String thread, String tag, String prefix) {
        MillsRecord millsRecord = mMap.get(thread);
        if (millsRecord != null) {
            millsRecord.print(thread, tag, prefix);
        }
        mMap.remove(thread);
    }

}
