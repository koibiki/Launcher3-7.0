package com.android.predict;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

/**
 * Created by orien on 2017/12/21.
 */

public class AppTypeInfo implements Comparable<AppTypeInfo> {

    public static String[] TYPES = {"BROWSER", "EFFICIENCY", "GAME", "MEDIA", "PAY", "READ", "SHOP", "SPORT", "STOCK", "STUDY", "TRAVEL"};

    public String appName;

    public Bitmap iconBitmap;

    public String packageName;

    public boolean isBrowser;

    public boolean isEfficiency;

    public boolean isGame;

    public boolean isIm;

    public boolean isMedia;

    public boolean isPay;

    public boolean isRead;

    public boolean isShop;

    public boolean isSport;

    public boolean isStock;

    public boolean isStudy;

    public boolean isTravel;

    public int currentPosition;

    void setTypeStatus(boolean status) {
        switch (currentPosition) {
            case Constants.TYPE_BROWSER:
                isBrowser = status;
                break;
            case Constants.TYPE_EFFICIENCY:
                isEfficiency = status;
                break;
            case Constants.TYPE_GAME:
                isGame = status;
                break;
            case Constants.TYPE_IM:
                isIm = status;
                break;
            case Constants.TYPE_MEDIA:
                isMedia = status;
                break;
            case Constants.TYPE_PAY:
                isPay = status;
                break;
            case Constants.TYPE_READ:
                isRead = status;
                break;
            case Constants.TYPE_SHOP:
                isShop = status;
                break;
            case Constants.TYPE_SPORT:
                isSport = status;
                break;
            case Constants.TYPE_STOCK:
                isStock = status;
                break;
            case Constants.TYPE_STUDY:
                isStudy = status;
                break;
            case Constants.TYPE_TRAVEL:
                isTravel = status;
                break;
        }
    }

    Boolean getTypeStatus() {
        switch (currentPosition) {
            case Constants.TYPE_BROWSER:
                return isBrowser;
            case Constants.TYPE_EFFICIENCY:
                return isEfficiency;
            case Constants.TYPE_GAME:
                return isGame;
            case Constants.TYPE_IM:
                return isIm;
            case Constants.TYPE_MEDIA:
                return isMedia;
            case Constants.TYPE_PAY:
                return isPay;
            case Constants.TYPE_READ:
                return isRead;
            case Constants.TYPE_SHOP:
                return isShop;
            case Constants.TYPE_SPORT:
                return isSport;
            case Constants.TYPE_STOCK:
                return isStock;
            case Constants.TYPE_STUDY:
                return isStudy;
            case Constants.TYPE_TRAVEL:
                return isTravel;
            default:
                return false;
        }
    }

    String getPinyin() {
        String pinyin = "";
        try {
            pinyin = PinyinHelper.convertToPinyinString(appName, "", PinyinFormat.WITHOUT_TONE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pinyin.toLowerCase();
    }

    @Override
    public int compareTo(@NonNull AppTypeInfo info) {
        int compareResult = info.getTypeStatus().compareTo(getTypeStatus());
        if (compareResult == 0) {
            return getPinyin().compareTo(info.getPinyin());
        } else {
            return compareResult;
        }
    }
}
