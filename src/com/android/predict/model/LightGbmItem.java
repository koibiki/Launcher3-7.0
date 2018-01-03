package com.android.predict.model;

import com.android.predict.dao.AppType;
import com.android.predict.dao.User;
import com.android.predict.utils.ModelValueUtils;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.List;

/**
 * Created by orien on 2017/12/25.
 */

public class LightGbmItem {

    private Long id;

    private boolean isBrowser;

    private boolean isEfficiency;

    private boolean isGame;

    private boolean isIm;

    private boolean isMedia;

    private boolean isPay;

    private boolean isRead;

    private boolean isShop;

    private boolean isSport;

    private boolean isStock;

    private boolean isStudy;

    private boolean isTravel;

    private boolean isO2o;

    private boolean isWifiConnect;

    private boolean isMobileConnect;

    private double latitude;

    private double longtitude;

    private boolean isFebruary;

    private boolean isSpring;

    private boolean isSummer;

    private boolean isAutumn;

    private boolean isWinter;

    private boolean isMatinal;

    private boolean isMorning;

    private boolean isNoon;

    private boolean isAfternoon;

    private boolean isEvening;

    private boolean isNight;

    private boolean isBeginOfMouth;

    private boolean isEndOfMouth;

    private boolean isWeekend;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isBrowser() {
        return isBrowser;
    }

    public void setBrowser(boolean browser) {
        isBrowser = browser;
    }

    public boolean isEfficiency() {
        return isEfficiency;
    }

    public void setEfficiency(boolean efficiency) {
        isEfficiency = efficiency;
    }

    public boolean isGame() {
        return isGame;
    }

    public void setGame(boolean game) {
        isGame = game;
    }

    public boolean isIm() {
        return isIm;
    }

    public void setIm(boolean im) {
        isIm = im;
    }

    public boolean isMedia() {
        return isMedia;
    }

    public void setMedia(boolean media) {
        isMedia = media;
    }

    public boolean isPay() {
        return isPay;
    }

    public void setPay(boolean pay) {
        isPay = pay;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isShop() {
        return isShop;
    }

    public void setShop(boolean shop) {
        isShop = shop;
    }

    public boolean isSport() {
        return isSport;
    }

    public void setSport(boolean sport) {
        isSport = sport;
    }

    public boolean isSpring() {
        return isSpring;
    }

    public void setSpring(boolean spring) {
        isSpring = spring;
    }

    public boolean isSummer() {
        return isSummer;
    }

    public void setSummer(boolean summer) {
        isSummer = summer;
    }

    public boolean isAutumn() {
        return isAutumn;
    }

    public void setAutumn(boolean autumn) {
        isAutumn = autumn;
    }

    public boolean isWinter() {
        return isWinter;
    }

    public void setWinter(boolean winter) {
        isWinter = winter;
    }

    public boolean isStock() {
        return isStock;
    }

    public void setStock(boolean stock) {
        isStock = stock;
    }

    public boolean isStudy() {
        return isStudy;
    }

    public void setStudy(boolean study) {
        isStudy = study;
    }

    public boolean isTravel() {
        return isTravel;
    }

    public void setTravel(boolean travel) {
        isTravel = travel;
    }

    public boolean isO2o() {
        return isO2o;
    }

    public void setO2o(boolean o2o) {
        isO2o = o2o;
    }

    public boolean isWifiConnect() {
        return isWifiConnect;
    }

    public void setWifiConnect(boolean wifiConnect) {
        this.isWifiConnect = wifiConnect;
    }

    public boolean isMobileConnect() {
        return isMobileConnect;
    }

    public void setMobileConnect(boolean mobileConnect) {
        this.isMobileConnect = mobileConnect;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public boolean isFebruary() {
        return isFebruary;
    }

    public void setFebruary(boolean february) {
        isFebruary = february;
    }

    public boolean isMatinal() {
        return isMatinal;
    }

    public void setMatinal(boolean matinal) {
        isMatinal = matinal;
    }

    public boolean isMorning() {
        return isMorning;
    }

    public void setMorning(boolean morning) {
        isMorning = morning;
    }

    public boolean isNoon() {
        return isNoon;
    }

    public void setNoon(boolean noon) {
        isNoon = noon;
    }

    public boolean isAfternoon() {
        return isAfternoon;
    }

    public void setAfternoon(boolean afternoon) {
        isAfternoon = afternoon;
    }

    public boolean isEvening() {
        return isEvening;
    }

    public void setEvening(boolean evening) {
        isEvening = evening;
    }

    public boolean isNight() {
        return isNight;
    }

    public void setNight(boolean night) {
        isNight = night;
    }

    public boolean isBeginOfMouth() {
        return isBeginOfMouth;
    }

    public void setBeginOfMouth(boolean beginOfMouth) {
        isBeginOfMouth = beginOfMouth;
    }

    public boolean isEndOfMouth() {
        return isEndOfMouth;
    }

    public void setEndOfMouth(boolean endOfMouth) {
        isEndOfMouth = endOfMouth;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public LightGbmItem(@NotNull AppType appType, @NotNull User userAction) {
        this.id = appType.getId();

        this.isBrowser = appType.getIsBrowser();

        this.isEfficiency = appType.getIsEfficiency();

        this.isGame = appType.getIsGame();

        this.isIm = appType.getIsIm();

        this.isMedia = appType.getIsMedia();

        this.isPay = appType.getIsPay();

        this.isRead = appType.getIsRead();

        this.isShop = appType.getIsShop();

        this.isSport = appType.getIsSport();

        this.isStock = appType.getIsStock();

        this.isStudy = appType.getIsStudy();

        this.isTravel = appType.getIsTravel();

        this.isO2o = appType.getIsO2o();

        this.isWifiConnect = userAction.getWifiConnect();

        this.isMobileConnect = userAction.getMobileConnect();

        this.latitude = userAction.getLatitude();

        this.longtitude = userAction.getLongtitude();

        this.isFebruary = userAction.getIsFebruary();

        this.isSpring = userAction.getIsSpring();

        this.isSummer = userAction.getIsSummer();

        this.isAutumn = userAction.getIsAutumn();

        this.isWinter = userAction.getIsWinter();

        this.isMatinal = userAction.getIsMatinal();

        this.isNoon = userAction.getIsNoon();

        this.isAfternoon = userAction.getIsAfternoon();

        this.isEvening = userAction.getIsEvening();

        this.isNight = userAction.getIsNight();

        this.isBeginOfMouth = userAction.getIsBeginOfMouth();

        this.isEndOfMouth = userAction.getIsEndOfMouth();

        this.isWeekend = userAction.getIsWeekend();
    }

    private String separator = "\t";

    @Override
    public String toString() {
        List<ModelValueUtils.ClassInfo> filedsInfo = ModelValueUtils.getFiledsInfo(this);
        StringBuilder sb = new StringBuilder(id.toString() + separator);
        for (ModelValueUtils.ClassInfo field : filedsInfo) {
            if (!field.getName().equals("id") && !field.getName().equals("separator")) {
                sb.append(field.getValue() + separator);
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    public String getTypeFileds() {
        List<String> filedNames = ModelValueUtils.getFiledNames(this);
        StringBuilder sb = new StringBuilder("id" + separator);
        for (String field : filedNames) {
            if (!field.equals("id") && !field.equals("separator")) {
                sb.append(field + separator);
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

}
