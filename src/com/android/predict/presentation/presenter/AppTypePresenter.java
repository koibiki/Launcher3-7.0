package com.android.predict.presentation.presenter;

import com.android.predict.AppTypeInfo;
import com.android.predict.dao.AppType;
import com.android.predict.domain.interactor.usecase.GetAllApp;
import com.android.predict.domain.interactor.usecase.SaveAppTypeData;
import com.android.predict.domain.interactor.usecase.UseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by chengli on 17-12-22.
 */

public class AppTypePresenter implements AppTypeContact.Presenter {

    private UseCase<Object, List<AppTypeInfo>> getAllApp;

    private UseCase<List<AppTypeInfo>, Object> saveAppTypeData;

    @Inject
    public AppTypePresenter(GetAllApp getAllApp, SaveAppTypeData saveAppTypeData) {
        this.getAllApp = getAllApp;
        this.saveAppTypeData = saveAppTypeData;
    }

    public void getAllAppType() {
        getAllApp.execute(null);
    }

    public void cancel() {
        getAllApp.unsubscribe();
    }

    @Override
    public void saveAppTypeData(List<AppTypeInfo> appTypeInfos) {
        saveAppTypeData.execute(appTypeInfos);
    }
}
