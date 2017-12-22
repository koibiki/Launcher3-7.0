package com.android.predict.presentation.internal.module;

import android.content.Context;

import com.android.predict.LauncherApplication;
import com.android.predict.database.GreenDaoInstance;
import com.android.predict.domain.excutor.JobExecutor;
import com.android.predict.domain.excutor.PostExecutionThread;
import com.android.predict.domain.excutor.UIThread;
import com.android.predict.database.Database;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    Database provideDataBase(GreenDaoInstance greenDaoInstance) {
        return greenDaoInstance;
    }

}
