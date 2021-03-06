package com.android.predict;

import android.os.Environment;

import java.io.File;

/**
 * Created by orien on 2017/12/14.
 */

public class Constants {

    public final static int TYPE_BROWSER = 0;
    public final static int TYPE_EFFICIENCY = 1;
    public final static int TYPE_GAME = 2;
    public final static int TYPE_IM = 3;
    public final static int TYPE_MEDIA = 4;
    public final static int TYPE_PAY = 5;
    public final static int TYPE_READ = 6;
    public final static int TYPE_SHOP = 7;
    public final static int TYPE_SPORT = 8;
    public final static int TYPE_STOCK = 9;
    public final static int TYPE_STUDY = 10;
    public final static int TYPE_TRAVEL = 11;
    public final static int TYPE_O2O = 12;
    public final static int TYPE_USELESS = 13;

    public final static String TYPE_POSITION = "type_position";

    public final static String[] TYPES = {"BROWSER", "EFFICIENCY", "GAME", "IM", "MEDIA", "PAY", "READ", "SHOP", "SPORT", "STOCK", "STUDY", "TRAVEL", "O2O", "USELESS"};

    public final static String TRAIN_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath()
            + File.separator + "Launcher" + File.separator + "model";

    public final static String ACTION_SERVICE = "action_service";

    public final static String ACTION_TRAIN = "intent.action.TRAINING_SERVICE";

    public final static String ACTION_PREDICT = "intent.action.PREDICTING_SERVICE";

}
