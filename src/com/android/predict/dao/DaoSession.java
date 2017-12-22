package com.android.predict.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.android.predict.dao.AppType;
import com.android.predict.dao.User;

import com.android.predict.dao.AppTypeDao;
import com.android.predict.dao.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig appTypeDaoConfig;
    private final DaoConfig userDaoConfig;

    private final AppTypeDao appTypeDao;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        appTypeDaoConfig = daoConfigMap.get(AppTypeDao.class).clone();
        appTypeDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        appTypeDao = new AppTypeDao(appTypeDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(AppType.class, appTypeDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        appTypeDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
    }

    public AppTypeDao getAppTypeDao() {
        return appTypeDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}
