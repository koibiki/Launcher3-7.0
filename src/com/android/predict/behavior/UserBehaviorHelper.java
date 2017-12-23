package com.android.predict.behavior;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.android.predict.dao.User;
import com.android.predict.database.Database;
import com.android.predict.utils.DateUtils;

import java.util.Date;

/**
 * Created by orien on 2017/12/12.
 */

public class UserBehaviorHelper {

    public static void saveUserClickData(Context context, Intent intent, Database database) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            User user = new User();
            setDate(user);
            user.setWifiConnect(UserBehaviorHelper.isWifi(context));
            user.setMobileConnect(UserBehaviorHelper.isMobile(context));
            user.setPackageName(component.getPackageName());
            Location location = UserBehaviorHelper.getLocation(context);
            user.setLatitude(location == null ? -1 : location.getLatitude());
            user.setLongtitude(location == null ? -1 : location.getLongitude());
            database.insertUserBehavior(user);
        }
    }

    private static void setDate(User user) {
        Date currentTime = new Date();
        user.setDate(currentTime.getTime());
        setDayOfWeek(currentTime, user);
        setMonthOfYear(currentTime, user);
        setHourOfDay(currentTime, user);
        setDayOfMouth(currentTime, user);
    }

    private static void setDayOfMouth(Date currentTime, User user) {
        int dayOfMouth = DateUtils.getDayOfMouth(currentTime);
        user.setIsBeginOfMouth(dayOfMouth <= 7);
        user.setIsEndOfMouth(dayOfMouth >= 25);
    }

    private static void setHourOfDay(Date currentTime, User user) {
        int hourOfDay = DateUtils.getHourOfDay(currentTime);
        user.setIsZero(hourOfDay == 0);
        user.setIsOne(hourOfDay == 1);
        user.setIsTwo(hourOfDay == 2);
        user.setIsThree(hourOfDay == 3);
        user.setIsFour(hourOfDay == 4);
        user.setIsFive(hourOfDay == 5);
        user.setIsSix(hourOfDay == 6);
        user.setIsSeven(hourOfDay == 7);
        user.setIsEight(hourOfDay == 8);
        user.setIsNine(hourOfDay == 9);
        user.setIsTen(hourOfDay == 10);
        user.setIsEleven(hourOfDay == 11);
        user.setIsTwelve(hourOfDay == 12);
        user.setIsThirteen(hourOfDay == 13);
        user.setIsForteen(hourOfDay == 14);
        user.setIsFifteen(hourOfDay == 15);
        user.setIsSixteen(hourOfDay == 16);
        user.setIsSeveteen(hourOfDay == 17);
        user.setIsEighteen(hourOfDay == 18);
        user.setIsNineteen(hourOfDay == 19);
        user.setIsTwenty(hourOfDay == 20);
        user.setIsTwentyone(hourOfDay == 21);
        user.setIsTwentytwo(hourOfDay == 22);
        user.setIsTwentthree(hourOfDay == 23);
        user.setIsMonning(hourOfDay >= 6 && hourOfDay < 11);
        user.setIsNoon(hourOfDay >= 11 && hourOfDay < 13);
        user.setIsAfternoon(hourOfDay >= 13 && hourOfDay < 18);
        user.setIsEvening(hourOfDay >= 18 && hourOfDay < 22);
        user.setIsNight(hourOfDay >= 22 || hourOfDay < 6);
    }

    private static void setMonthOfYear(Date currentTime, User user) {
        int monthOfYear = DateUtils.getMonthOfYear(currentTime);
        user.setIsJanuary(monthOfYear == 1);
        user.setIsFebruary(monthOfYear == 2);
        user.setIsMarch(monthOfYear == 3);
        user.setIsApril(monthOfYear == 4);
        user.setIsMay(monthOfYear == 5);
        user.setIsJune(monthOfYear == 6);
        user.setIsJuly(monthOfYear == 7);
        user.setIsAugust(monthOfYear == 8);
        user.setIsSeptember(monthOfYear == 9);
        user.setIsOctober(monthOfYear == 10);
        user.setIsNovember(monthOfYear == 11);
        user.setIsDecember(monthOfYear == 12);
    }

    private static void setDayOfWeek(Date currentTime, User user) {
        int dayOfWeek = DateUtils.getDayOfWeek(currentTime);
        user.setIsSunday(dayOfWeek == 1);
        user.setIsMonday(dayOfWeek == 2);
        user.setIsThursday(dayOfWeek == 3);
        user.setIsWednesday(dayOfWeek == 4);
        user.setIsThesday(dayOfWeek == 5);
        user.setIsFriday(dayOfWeek == 6);
        user.setIsSaturday(dayOfWeek == 7);
        user.setIsWorkday(dayOfWeek != 1 && dayOfWeek != 7);
        user.setIsWeekend(dayOfWeek == 1 || dayOfWeek == 7);
    }

    private static boolean isWifi(Context context) {
        return NetworkHelper.isWifiConnected(context);
    }

    private static boolean isMobile(Context context) {
        return NetworkHelper.isMobileConnected(context);
    }

    private static Location getLocation(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        Location location = null;
        if (PackageManager.PERMISSION_GRANTED == context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)) {
            if (locationManager != null && locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            }
            if (locationManager != null && location == null && NetworkHelper.isMobileConnected(context)) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, locationListener);
                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }
        }
        return location;
    }

    private static LocationListener locationListener = new LocationListener() {

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }

        @Override
        public void onLocationChanged(Location location) {

        }
    };
}
