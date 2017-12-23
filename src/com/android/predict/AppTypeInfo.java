package com.android.predict;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

/**
 * Created by orien on 2017/12/21.
 */

public class AppTypeInfo implements Comparable<AppTypeInfo> {

    private Long id;

    private String appName;

    private String pinyin;

    private Bitmap iconBitmap;

    private String packageName;

    private boolean isBrowser;

    private boolean isEfficiency;

    private boolean isGame;

    private boolean isIm;

    private boolean isMedia;

    private boolean isPay;

    private boolean isRead;

    private boolean isShop;

    private boolean isSport;

    private boolean isStock;

    private boolean isStudy;

    private boolean isTravel;

    private int currentPosition;

    private boolean isO2o;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
        setPinyin(getPinyin());
    }

    private void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public Bitmap getIconBitmap() {
        return iconBitmap;
    }

    public void setIconBitmap(Bitmap iconBitmap) {
        this.iconBitmap = iconBitmap;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public boolean isBrowser() {
        return isBrowser;
    }

    public void setBrowser(boolean browser) {
        isBrowser = browser;
    }

    public boolean isEfficiency() {
        return isEfficiency;
    }

    public void setEfficiency(boolean efficiency) {
        isEfficiency = efficiency;
    }

    public boolean isGame() {
        return isGame;
    }

    public void setGame(boolean game) {
        isGame = game;
    }

    public boolean isIm() {
        return isIm;
    }

    public void setIm(boolean im) {
        isIm = im;
    }

    public boolean isMedia() {
        return isMedia;
    }

    public void setMedia(boolean media) {
        isMedia = media;
    }

    public boolean isPay() {
        return isPay;
    }

    public void setPay(boolean pay) {
        isPay = pay;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isShop() {
        return isShop;
    }

    public void setShop(boolean shop) {
        isShop = shop;
    }

    public boolean isSport() {
        return isSport;
    }

    public void setSport(boolean sport) {
        isSport = sport;
    }

    public boolean isStock() {
        return isStock;
    }

    public void setStock(boolean stock) {
        isStock = stock;
    }

    public boolean isStudy() {
        return isStudy;
    }

    public void setStudy(boolean study) {
        isStudy = study;
    }

    public boolean isTravel() {
        return isTravel;
    }

    public void setTravel(boolean travel) {
        isTravel = travel;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isO2o() {
        return isO2o;
    }

    public void setO2o(boolean o2o) {
        isO2o = o2o;
    }

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
            case Constants.TYPE_O2O:
                isO2o = status;
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
            case Constants.TYPE_O2O:
                return isO2o;
            default:
                return false;
        }
    }

    private String getPinyin() {
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
            return pinyin.compareTo(info.pinyin);
        } else {
            return compareResult;
        }
    }
}
