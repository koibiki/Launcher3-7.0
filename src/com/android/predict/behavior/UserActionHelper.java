package com.android.predict.behavior;

import android.Manifest;
import android.content.Context;
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

public class UserActionHelper {

    public static void saveUserClickData(Context context, String packageName, Database database) {
        User user = createUserAction(context, packageName);
        database.insertUserBehavior(user);

    }

    public static User createUserAction(Context context, String packageName) {
        User user = new User();
        setDate(user);
        user.setPackageName(packageName);
        user.setWifiConnect(UserActionHelper.isWifi(context));
        user.setMobileConnect(UserActionHelper.isMobile(context));
        Location location = UserActionHelper.getLocation(context);
        user.setLatitude(location == null ? -1 : location.getLatitude());
        user.setLongtitude(location == null ? -1 : location.getLongitude());
        return user;
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
        user.setIsMatinal(hourOfDay >= 6 && hourOfDay < 9);
        user.setIsMorning(hourOfDay >= 9 && hourOfDay < 11);
        user.setIsNoon(hourOfDay >= 11 && hourOfDay < 13);
        user.setIsAfternoon(hourOfDay >= 13 && hourOfDay < 18);
        user.setIsEvening(hourOfDay >= 18 && hourOfDay < 23);
        user.setIsNight(hourOfDay >= 23 || hourOfDay < 6);
    }

    private static void setMonthOfYear(Date currentTime, User user) {
        int monthOfYear = DateUtils.getMonthOfYear(currentTime);
        user.setIsSpring(monthOfYear >= 2 && monthOfYear <= 5);
        user.setIsFebruary(monthOfYear == 2);
        user.setIsSummer(monthOfYear >= 6 && monthOfYear <= 8);
        user.setIsAutumn(monthOfYear == 9 || monthOfYear == 10);
        user.setIsWinter(monthOfYear == 1 || monthOfYear >= 11);
    }

    private static void setDayOfWeek(Date currentTime, User user) {
        int dayOfWeek = DateUtils.getDayOfWeek(currentTime);
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
