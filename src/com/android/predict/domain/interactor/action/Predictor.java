package com.android.predict.domain.interactor.action;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.predict.TestJni;
import com.android.predict.behavior.UserActionHelper;
import com.android.predict.dao.AppType;
import com.android.predict.dao.User;
import com.android.predict.database.Database;
import com.android.predict.domain.excutor.PostExecutor;
import com.android.predict.model.LightGbmItem;
import com.android.predict.utils.AssetsCopyTOSDcard;
import com.android.predict.utils.MillsRecordUtils;

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

import io.reactivex.Flowable;

import static com.android.predict.Constants.TRAIN_ROOT;

/**
 * Created by orien on 2017/12/25.
 */

public class Predictor {

    private static final String TAG = Predictor.class.getName();

    private Context mContext;
    private Executor mExecutor;
    private PostExecutor mUiThread;
    private Database mDatabase;

    private String mTrainFilePath = TRAIN_ROOT + File.separator + "multiclass.train";

    private String mValidFilePath = TRAIN_ROOT + File.separator + "multiclass.test";

    private String mPredictFilePath = TRAIN_ROOT + File.separator + "multiclass.predict";

    private String mTrainConfigAssetPath = "train.conf";

    private String mTrainConfigFilePath = TRAIN_ROOT + File.separator + mTrainConfigAssetPath;

    private String mPredictConfigAssetPath = "predict.conf";

    private String mPredictConfigFilePath = TRAIN_ROOT + File.separator + mTrainConfigAssetPath;

    private int mClassNum;

    @Inject
    public Predictor(Context context, Executor threadExecutor, PostExecutor uiThread, Database database) {
        mContext = context;
        mExecutor = threadExecutor;
        mUiThread = uiThread;
        mDatabase = database;
    }


    public void trainModel() {
        MillsRecordUtils.startRecord(Thread.currentThread().getName());
        boolean success = createTrainFile();
        MillsRecordUtils.print(Thread.currentThread().getName(), TAG, "create train file : ");

        createTrainConfig();

        if (success) {
            TestJni.trainModel(mClassNum);
            mUiThread.getScheduler().scheduleDirect(() -> Toast.makeText(mContext, "train finish.", Toast.LENGTH_SHORT).show());
        }
    }

    public void predict() {
        MillsRecordUtils.startRecord(Thread.currentThread().getName());
        boolean success = createPredictFile();
        MillsRecordUtils.print(Thread.currentThread().getName(), TAG, "create train file : ");

        createPredictConfig();

        if (success) {
            TestJni.predict();
            mUiThread.getScheduler().scheduleDirect(() -> Toast.makeText(mContext, "train finish.", Toast.LENGTH_SHORT).show());
        }
    }

    private void createTrainConfig() {
        AssetsCopyTOSDcard.copyAssets(mContext, mTrainConfigAssetPath, mTrainConfigFilePath);
    }

    private void createPredictConfig() {
        AssetsCopyTOSDcard.copyAssets(mContext, mPredictConfigAssetPath, mPredictConfigFilePath);
    }

    private List<LightGbmItem> createTrainData() {
        List<AppType> allAppType = mDatabase.getAllAppType();
        mClassNum = allAppType.size();
        HashMap<String, AppType> appTypeMap = new HashMap<>();

        Flowable.fromIterable(allAppType)
                .subscribe(appType -> appTypeMap.put(appType.getPackageName(), appType));

        List<LightGbmItem> lightGbmItems = new ArrayList<>();

        Flowable.fromIterable(mDatabase.getAllUserBehavior(0))
                .filter(user -> !mContext.getPackageName().equals(user.getPackageName()))
                .filter(user -> appTypeMap.get(user.getPackageName()) != null)
                .subscribe(user -> {
                    LightGbmItem lightGbmItem = new LightGbmItem(appTypeMap.get(user.getPackageName()), user);
                    lightGbmItems.add(lightGbmItem);
                    Log.w(TAG, user.getPackageName() + "\t" + lightGbmItem.toString());
                });
        return lightGbmItems;
    }

    private boolean createPredictFile() {
        List<LightGbmItem> predictData = createPredictData();
        File predict = new File(mPredictFilePath);
        FileWriter predictWriter = null;
        BufferedWriter predictBufferedWriter = null;
        try {
            predictWriter = new FileWriter(predict);
            predictBufferedWriter = new BufferedWriter(predictWriter);
            int size = predictData.size();
            for (int i = 0; i < size; i++) {
                String trainDataItem = predictData.get(i).toString();
                predictBufferedWriter.write(trainDataItem);
                predictBufferedWriter.newLine();
                predictBufferedWriter.flush();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            close(predictBufferedWriter);
            close(predictWriter);
        }
    }

    private List<LightGbmItem> createPredictData() {
        List<LightGbmItem> list = new ArrayList<>();
        Flowable.fromIterable(mDatabase.getAllAppType())
                .subscribe(appType -> {
                    User userAction = UserActionHelper.createUserAction(mContext, null);
                    LightGbmItem item = new LightGbmItem(appType, userAction);
                    list.add(item);
                });
        return list;
    }

    private boolean createTrainFile() {
        List<LightGbmItem> trainData = createTrainData();

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
                String trainDataItem = trainData.get(i).toString();
                trainBufferedWriter.write(trainDataItem);
                trainBufferedWriter.newLine();
                trainBufferedWriter.flush();
                if (i >= validIndex) {
                    validBufferedWriter.write(trainDataItem);
                    validBufferedWriter.newLine();
                    validBufferedWriter.flush();
                }
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
