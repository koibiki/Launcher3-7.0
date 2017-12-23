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

    private Context mContext;
    private Database mDatabase;
    private Map<String, AppTypeInfo> mAppTypeInfos;

    @Inject
    public AppDaoHelper(Context context, Database database) {
        mContext = context;
        mDatabase = database;
    }

    public synchronized Map<String, AppTypeInfo> getAppTypeInfos() {
        if (mAppTypeInfos == null) {
            mAppTypeInfos = new HashMap<>();
            List<AppType> appTypes = mDatabase.getAllAppType();
            for (AppType appType : appTypes) {
                if (!mContext.getPackageName().equals(appType.getPackageName())) {
                    mAppTypeInfos.put(appType.getPackageName(), transferAppTypeInfo(appType));
                }
            }
        }
        return mAppTypeInfos;
    }

    public synchronized void deleteAppType(AppTypeInfo appTypeInfo) {
        mDatabase.deleteAppType(transferApptype(appTypeInfo));
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
        appType.setId(appTypeInfo.getId());
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
