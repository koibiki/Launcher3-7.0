package com.android.predict.presentation.internal.module;

import android.content.Context;

import com.android.predict.LauncherApplication;
import com.android.predict.database.GreenDaoInstance;
import com.android.predict.domain.excutor.DaoExecutor;
import com.android.predict.domain.excutor.GreenDaoThread;
import com.android.predict.domain.excutor.JobExecutor;
import com.android.predict.domain.excutor.PostExecutor;
import com.android.predict.domain.excutor.UIThread;
import com.android.predict.database.Database;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 *  所有singleton的對象必須通過 provider 提供
 *  provide的對象必須是通過 interface 提供
 *  同一個 interface 衹能提供一個對象
 *  其他對象只需在需要出 inject 即可
 *  注意 inject 元素的依賴
 *  其他普通 component 需要添加 scope
 */
@Module
public class ApplicationModule {
    private final LauncherApplication application;

    public ApplicationModule(LauncherApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return this.application;
    }

    @Provides
    @Singleton
    Executor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutor providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    Database provideDataBase(GreenDaoInstance greenDaoInstance) {
        return greenDaoInstance;
    }

    @Provides
    @Singleton
    DaoExecutor provideGreenDaoExecutor(GreenDaoThread greenDaoThread) {
        return greenDaoThread;
    }

}
