package com.android.predict.dao;

import com.android.predict.AppTypeInfo;

/**
 * Created by chengli on 17-12-22.
 */

public class AppDaoHelper {

    public static AppTypeInfo transferAppTypeInfo(AppType appType) {
        AppTypeInfo appTypeInfo = new AppTypeInfo();
        appTypeInfo.setPackageName(appType.getPackageName());
        appTypeInfo.setBrowser(appType.getIsBrowser());
        appTypeInfo.setEfficiency(appType.getIsEfficiency());
        appTypeInfo.setGame(appType.getIsGame());
        appTypeInfo.setIm(appType.getIsIm());
        appTypeInfo.setMedia(appType.getIsMedia());
        appTypeInfo.setPay(appType.getIsPay());
        appTypeInfo.setRead(appType.getIsRead());
        appTypeInfo.setShop(appType.getIsShop());
        appTypeInfo.setSport(appType.getIsSport());
        appTypeInfo.setStock(appType.getIsStock());
        appTypeInfo.setStudy(appType.getIsStudy());
        appTypeInfo.setTravel(appType.getIsTravel());
        appTypeInfo.setO2o(appType.getIsO2o());
        return appTypeInfo;
    }

    public static AppType transferApptype(AppTypeInfo appTypeInfo) {
        AppType appType = new AppType();
        appType.setPackageName(appTypeInfo.getPackageName());
        appType.setIsBrowser(appTypeInfo.isBrowser());
        appType.setIsEfficiency(appTypeInfo.isEfficiency());
        appType.setIsGame(appTypeInfo.isGame());
        appType.setIsIm(appTypeInfo.isIm());
        appType.setIsMedia(appTypeInfo.isMedia());
        appType.setIsPay(appTypeInfo.isPay());
        appType.setIsRead(appTypeInfo.isRead());
        appType.setIsShop(appTypeInfo.isShop());
        appType.setIsSport(appTypeInfo.isSport());
        appType.setIsStock(appTypeInfo.isStock());
        appType.setIsStudy(appTypeInfo.isStudy());
        appType.setIsTravel(appTypeInfo.isTravel());
        appType.setIsO2o(appTypeInfo.isO2o());
        return appType;
    }

}
