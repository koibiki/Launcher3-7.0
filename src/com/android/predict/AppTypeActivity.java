package com.android.predict;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.launcher3.AppInfo;
import com.android.launcher3.LauncherAppState;
import com.android.launcher3.R;
import com.android.predict.dao.AppDaoHelper;
import com.android.predict.dao.AppType;
import com.android.predict.presentation.DaggerActivity;
import com.android.predict.presentation.internal.component.DaggerAppTypeComponent;
import com.android.predict.presentation.internal.module.AppTypeModule;
import com.android.predict.presentation.presenter.AppTypeContact;
import com.android.predict.presentation.presenter.AppTypePresenter;
import com.android.predict.presentation.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by orien on 2017/12/21.
 */

public class AppTypeActivity extends DaggerActivity implements AppTypeContact.View{

    private AppsAdapter mAdapter;

    @Inject
    AppTypePresenter mAppTypePresent;

    @Inject
    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerAppTypeComponent.builder()
                .applicationComponent(getApplicationComponent())
                .appTypeModule(new AppTypeModule(this,this))
                .build().inject(this);

        RecyclerView recyclerView = new RecyclerView(this);
        setContentView(recyclerView);
        int typePosition = getIntent().getIntExtra(Constants.TYPE_POSITION, 0);
        setTitle(Constants.TYPES[typePosition]);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new AppsAdapter();
        recyclerView.setAdapter(mAdapter);
        ArrayList<AppInfo> allAppsList = LauncherAppState.getInstance().getModel().getBgAllAppsList().data;

        mAppTypePresent.show();

        mMainPresenter.loadData();

        List<AppType> appTypes = mAppTypePresent.getAllAppType();

        new Thread(() -> {

            HashMap<String, AppTypeInfo> typeMap = new HashMap<>();
            for (AppType appType : appTypes) {
                AppTypeInfo appTypeInfo = AppDaoHelper.transferAppTypeInfo(appType);
                typeMap.put(appTypeInfo.packageName, appTypeInfo);
            }

            for (AppInfo appInfo : allAppsList) {
                String packageName = appInfo.componentName.getPackageName();
                AppTypeInfo appTypeInfo = typeMap.get(packageName);
                if (appTypeInfo == null) {
                    appTypeInfo = new AppTypeInfo();
                    appTypeInfo.packageName = packageName;
                    typeMap.put(packageName, appTypeInfo);
                }
                appTypeInfo.currentPosition = typePosition;
                appTypeInfo.appName = appInfo.title.toString();
                appTypeInfo.iconBitmap = appInfo.iconBitmap;
            }
            ArrayList<AppTypeInfo> appTypeInfos = new ArrayList<>(typeMap.values());
            Collections.sort(appTypeInfos);
            runOnUiThread(() -> {
                mAdapter.setData(appTypeInfos);
            });

        }).start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        List<AppTypeInfo> data = mAdapter.getData();
        for (AppTypeInfo appTypeInfo : data) {
            AppType appType = AppDaoHelper.transferApptype(appTypeInfo);
            //GreenDaoInstance.getInstance(this).insertAppType(appType);
        }
    }

    @Override
    public void loadSuccess() {

    }

    class AppsAdapter extends RecyclerView.Adapter<AppItemHolder> {

        List<AppTypeInfo> mList = new ArrayList<>();

        @Override
        public AppItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = View.inflate(parent.getContext(), R.layout.item_app, null);
            return new AppItemHolder(inflate);
        }

        @Override
        public void onBindViewHolder(AppItemHolder holder, int position) {
            holder.bindData(mList.get(position));
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        void setData(List<AppTypeInfo> appTypeInfos) {
            mList.clear();
            mList.addAll(appTypeInfos);
            notifyDataSetChanged();
        }

        List<AppTypeInfo> getData() {
            return mList;
        }
    }

    class AppItemHolder extends RecyclerView.ViewHolder {

        private final View mRoot;
        private final TextView mTvAppName;
        private final ImageView mIvIcon;
        private final CheckBox mCb;

        AppItemHolder(View itemView) {
            super(itemView);
            mRoot = itemView;
            mTvAppName = itemView.findViewById(R.id.tv_app_name);
            mIvIcon = itemView.findViewById(R.id.iv_icon);
            mCb = itemView.findViewById(R.id.cb);
        }

        void bindData(AppTypeInfo appInfo) {
            mTvAppName.setText(appInfo.appName);
            mIvIcon.setImageBitmap(appInfo.iconBitmap);
            mCb.setChecked(appInfo.getTypeStatus());
            mRoot.setOnClickListener(v -> {
                appInfo.setTypeStatus(!appInfo.getTypeStatus());
                mCb.setChecked(appInfo.getTypeStatus());
            });
        }

    }

}
