package com.android.predict.utils;

import android.content.Context;
import android.util.Log;

import com.android.predict.dao.AppType;
import com.android.predict.dao.User;
import com.android.predict.database.Database;
import com.android.predict.model.TrainDataItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by orien on 2017/12/25.
 */

public class Predictor {

    private static final String TAG = Predictor.class.getName();

    public static List<TrainDataItem> createTrainData(Context context, Database database) {
        List<AppType> allAppType = database.getAllAppType();

        HashMap<String, AppType> appTypeMap = new HashMap<>();

        for (AppType appType : allAppType) {
            appTypeMap.put(appType.getPackageName(), appType);
        }

        List<TrainDataItem> trainDataItems = new ArrayList<>();
        List<User> allUserBehavior = database.getAllUserBehavior(0);
        for (User userBehavior : allUserBehavior) {
            String packageName = userBehavior.getPackageName();
            if (!context.getPackageName().equals(packageName)) {
                AppType appType = appTypeMap.get(packageName);
                TrainDataItem trainDataItem = new TrainDataItem(appType, userBehavior);
                trainDataItems.add(trainDataItem);
                Log.w(TAG, packageName +" " +trainDataItem.toString());
            }
        }
        return trainDataItems;
    }


}
