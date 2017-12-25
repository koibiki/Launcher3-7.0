package com.android.predict.database;

import android.content.Context;

import com.android.predict.dao.AppType;
import com.android.predict.model.AppTypeInfo;
import com.android.predict.database.Database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by chengli on 17-12-22.
 */

public class AppDaoHelper {


    public static synchronized Map<String, AppTypeInfo> getAppTypeInfos(Context context, Database database) {
        Map<String, AppTypeInfo> appTypeInfos = new HashMap<>();
        List<AppType> appTypes = database.getAllAppType();
        for (AppType appType : appTypes) {
            if (!context.getPackageName().equals(appType.getPackageName())) {
                appTypeInfos.put(appType.getPackageName(), transferAppTypeInfo(appType));
            }
        }
        return appTypeInfos;
    }

    public static synchronized void deleteAppType(Database database, AppTypeInfo appTypeInfo) {
        database.deleteAppType(transferApptype(appTypeInfo));
    }

    private static AppTypeInfo transferAppTypeInfo(AppType appType) {
        AppTypeInfo appTypeInfo = new AppTypeInfo();
        appTypeInfo.setId(appType.getId());
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
        if (appTypeInfo.getId() != -1) {
            appType.setId(appTypeInfo.getId());
        }
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
