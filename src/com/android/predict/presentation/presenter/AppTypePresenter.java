package com.android.predict.presentation.presenter;

import android.util.Log;

import com.android.predict.dao.AppType;
import com.android.predict.domain.excutor.PostExecutionThread;
import com.android.predict.database.Database;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

/**
 * Created by chengli on 17-12-22.
 */

public class AppTypePresenter {

    private Executor threadExecutor;
    private PostExecutionThread postExecutionThread;
    private Database database;

    @Inject
    public AppTypePresenter(Executor threadExecutor, PostExecutionThread postExecutionThread, Database database) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.database = database;
    }

    public List<AppType> getAllAppType() {
        return database.getAllAppType();
    }

    public void show() {
        Log.w("test", "init apptypePresenter");
    }
}
