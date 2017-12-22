package com.android.predict.presentation.presenter;

import javax.inject.Inject;

public class MainPresenter implements AppTypeContact.Presenter {

    private AppTypeContact.View mView;

    @Inject
    MainPresenter(AppTypeContact.View view) {
        mView = view;
    }

    public void loadData() {

        mView.loadSuccess();
    }

}