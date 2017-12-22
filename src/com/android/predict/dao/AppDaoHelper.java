package com.android.predict.dao;

import com.android.predict.AppTypeInfo;

/**
 * Created by chengli on 17-12-22.
 */

public class AppDaoHelper {

    public static AppTypeInfo transferAppTypeInfo(AppType appType) {
        AppTypeInfo appTypeInfo = new AppTypeInfo();
        appTypeInfo.packageName = appType.getPackageName();
        appTypeInfo.isBrowser = appType.getIsBrowser();
        appTypeInfo.isEfficiency = appType.getIsEfficiency();
        appTypeInfo.isGame = appType.getIsGame();
        appTypeInfo.isIm = appType.getIsIm();
        appTypeInfo.isMedia = appType.getIsMedia();
        appTypeInfo.isPay = appType.getIsPay();
        appTypeInfo.isRead = appType.getIsRead();
        appTypeInfo.isShop = appType.getIsShop();
        appTypeInfo.isSport = appType.getIsSport();
        appTypeInfo.isStock = appType.getIsStock();
        appTypeInfo.isStudy = appType.getIsStudy();
        appTypeInfo.isTravel = appType.getIsTravel();
        return appTypeInfo;
    }

    public static AppType transferApptype(AppTypeInfo appTypeInfo) {
        AppType appType = new AppType();
        appType.setPackageName(appTypeInfo.packageName);
        appType.setIsBrowser(appTypeInfo.isBrowser);
        appType.setIsEfficiency(appTypeInfo.isEfficiency);
        appType.setIsGame(appTypeInfo.isGame);
        appType.setIsIm(appTypeInfo.isIm);
        appType.setIsMedia(appTypeInfo.isMedia);
        appType.setIsPay(appTypeInfo.isPay);
        appType.setIsRead(appTypeInfo.isRead);
        appType.setIsShop(appTypeInfo.isShop);
        appType.setIsSport(appTypeInfo.isSport);
        appType.setIsStock(appTypeInfo.isStock);
        appType.setIsStudy(appTypeInfo.isStudy);
        appType.setIsTravel(appTypeInfo.isTravel);
        return appType;
    }

}
