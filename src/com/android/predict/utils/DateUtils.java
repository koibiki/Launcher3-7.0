package com.android.predict.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by orien on 2017/12/12.
 */

public class DateUtils {

    public static int getDayOfWeek(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance.get(Calendar.DAY_OF_WEEK);
    }

    public static int getMonthOfYear(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String format = formatter.format(date);
        String[] split = format.split("-");
        return Integer.parseInt(split[1]);
    }

    public static int getDayOfMouth(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String format = formatter.format(date);
        String[] split = format.split("-");
        return Integer.parseInt(split[2]);
    }

    public static int getHourOfDay(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String format = formatter.format(date);
        String[] split = format.split(" ");
        return Integer.parseInt(split[1].split(":")[0]);
    }

}
