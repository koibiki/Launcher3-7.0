package com.android.predict.domain.interactor.action;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.android.predict.TestJni;
import com.android.predict.dao.AppType;
import com.android.predict.dao.User;
import com.android.predict.database.Database;
import com.android.predict.domain.excutor.PostExecutor;
import com.android.predict.model.TrainDataItem;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

/**
 * Created by orien on 2017/12/25.
 */

public class Predictor {

    private static final String TAG = Predictor.class.getName();

    private Context mContext;
    private Executor mExecutor;
    private PostExecutor mUiThread;
    private Database mDatabase;

    private String mTrainFilePath = Environment.getExternalStorageDirectory().getAbsolutePath()
            + File.separator
            + "Launcher" + File.separator + "model"
            + File.separator + "multiclass.train";

    private String mValidFilePath = Environment.getExternalStorageDirectory().getAbsolutePath()
            + File.separator + "Launcher" + File.separator + "model"
            + File.separator + "multiclass.test";

    @Inject
    public Predictor(Context context, Executor threadExecutor, PostExecutor uiThread, Database database) {
        mContext = context;
        mExecutor = threadExecutor;
        mUiThread = uiThread;
        mDatabase = database;
    }


    public void trainPredictModel() {
        boolean success = createTrainFile();
        if (success) {
            TestJni.predict();
            mUiThread.getScheduler().scheduleDirect(() -> {
                Toast.makeText(mContext, "train finish.", Toast.LENGTH_SHORT).show();
            });
        }
    }

    private List<TrainDataItem> createTrainData() {
        List<AppType> allAppType = mDatabase.getAllAppType();

        HashMap<String, AppType> appTypeMap = new HashMap<>();

        for (AppType appType : allAppType) {
            appTypeMap.put(appType.getPackageName(), appType);
        }

        List<TrainDataItem> trainDataItems = new ArrayList<>();
        List<User> allUserBehavior = mDatabase.getAllUserBehavior(0);
        for (User userBehavior : allUserBehavior) {
            String packageName = userBehavior.getPackageName();
            if (!mContext.getPackageName().equals(packageName)) {
                AppType appType = appTypeMap.get(packageName);
                TrainDataItem trainDataItem = new TrainDataItem(appType, userBehavior);
                trainDataItems.add(trainDataItem);
                Log.w(TAG, packageName + " " + trainDataItem.toString());
            }
        }
        return trainDataItems;
    }

    private boolean createTrainFile() {
        List<TrainDataItem> trainData = createTrainData();

        File train = new File(mTrainFilePath);
        File valid = new File(mValidFilePath);
        FileWriter trainWriter = null;
        BufferedWriter trainBufferedWriter = null;
        FileWriter validWriter = null;
        BufferedWriter validBufferedWriter = null;
        try {
            trainWriter = new FileWriter(train);
            trainBufferedWriter = new BufferedWriter(trainWriter);
            validWriter = new FileWriter(valid);
            validBufferedWriter = new BufferedWriter(validWriter);
            int size = trainData.size();
            int validIndex = size * 2 / 3;
            for (int i = 0; i < size; i++) {
                TrainDataItem trainDataItem = trainData.get(i);
                trainBufferedWriter.write(trainDataItem.toString());
                trainBufferedWriter.newLine();
                trainBufferedWriter.flush();
                if (i >= validIndex) {
                    validBufferedWriter.write(trainDataItem.toString());
                    validBufferedWriter.newLine();
                    validBufferedWriter.flush();
                }
                validBufferedWriter.close();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            close(trainBufferedWriter);
            close(trainWriter);
            close(validBufferedWriter);
            close(validWriter);
        }

    }

    private void close(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
