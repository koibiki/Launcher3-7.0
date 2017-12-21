package com.android.launcher3.predict;

import android.graphics.Bitmap;

/**
 * Created by orien on 2017/12/21.
 */

public class AppTypeInfo {

    public String appName;

    public Bitmap iconBitmap;

    public String packageName;

    public boolean isBrowser;

    public boolean isEfficiency;
    public static int TYPE_GAME = 2;
    public static int TYPE_IM = 3;
    public static int TYPE_MEDIA = 4;
    public static int TYPE_PAY = 5;
    public static int TYPE_READ = 6;
    public static int TYPE_SHOP = 7;
    public static int TYPE_SPORT = 8;
    public static int TYPE_STOCK = 9;
    public static int TYPE_STUDY = 10;
    public static int TYPE_TRAVEL = 11;

}
