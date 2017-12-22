package com.android.predict.database;

import com.android.predict.AppTypeInfo;
import com.android.predict.dao.AppType;
import com.android.predict.dao.User;

import java.util.List;
import java.util.Map;

/**
 * Created by chengli on 17-12-22.
 */

public interface Database {

    void insertUserBehavior(User user);

    void insertAppType(AppType appType);

    void updateAppType(AppType appType);

    List<AppType> getAllAppType();

    Map<String, AppType> getAllAppTypeMap();

}
