package com.android.predict.domain.excutor;

import android.os.Looper;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

@Singleton
public class GreenDaoThread implements DaoExecutor {

    private Looper mLooper;

    @Inject
    public GreenDaoThread() {
        new Thread(() -> {
            Looper.prepare();
            mLooper = Looper.myLooper();
            Looper.loop();
        }, "GreenDaoThread").start();
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.from(mLooper);
    }
}
