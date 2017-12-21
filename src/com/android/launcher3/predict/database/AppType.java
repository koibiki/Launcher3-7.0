package com.android.launcher3.predict.database;

import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by orien on 2017/12/14.
 */

public class AppType {

    @Id
    private Long id;
    @Property(nameInDb = "PACKAGENAME")
    private String packageName;
    @Property(nameInDb = "appType")
    private int appType;

}
