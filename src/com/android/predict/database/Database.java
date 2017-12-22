package com.android.predict.database;

import com.android.predict.dao.AppType;
import com.android.predict.dao.User;

import java.util.List;

/**
 * Created by chengli on 17-12-22.
 */

public interface Database {

    void insertUserBehavior(User user);

    void insertAppType(AppType appType);

    void updateAppTypes(List<AppType> appTypes);

    void updateAppType(AppType appType);

    List<AppType> getAllAppType();
}
