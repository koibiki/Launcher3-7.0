package com.android.predict.model;

import com.android.predict.dao.AppType;
import com.android.predict.dao.User;
import com.android.predict.utils.ModelValueUtils;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.List;

/**
 * Created by orien on 2017/12/25.
 */

public class TrainDataItem {

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

    private boolean wifiConnect;

    private boolean mobileConnect;

    private double latitude;

    private double longtitude;

    private boolean isMonday;

    private boolean isThesday;

    private boolean isWednesday;

    private boolean isThursday;

    private boolean isFriday;

    private boolean isSaturday;

    private boolean isSunday;

    private boolean isJanuary;

    private boolean isFebruary;

    private boolean isMarch;

    private boolean isApril;

    private boolean isMay;

    private boolean isJune;

    private boolean isJuly;

    private boolean isAugust;

    private boolean isSeptember;

    private boolean isOctober;

    private boolean isNovember;

    private boolean isDecember;

    private boolean isZero;

    private boolean isOne;

    private boolean isTwo;

    private boolean isThree;

    private boolean isFour;

    private boolean isFive;

    private boolean isSix;

    private boolean isSeven;

    private boolean isEight;

    private boolean isNine;

    private boolean isTen;

    private boolean isEleven;

    private boolean isTwelve;

    private boolean isThirteen;

    private boolean isForteen;

    private boolean isFifteen;

    private boolean isSixteen;

    private boolean isSeveteen;

    private boolean isEighteen;

    private boolean isNineteen;

    private boolean isTwenty;

    private boolean isTwentyone;

    private boolean isTwentytwo;

    private boolean isTwentthree;

    private boolean isMonning;

    private boolean isNoon;

    private boolean isAfternoon;

    private boolean isEvening;

    private boolean isNight;

    private boolean isBeginOfMouth;

    private boolean isEndOfMouth;

    private boolean isWorkday;

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
        return wifiConnect;
    }

    public void setWifiConnect(boolean wifiConnect) {
        this.wifiConnect = wifiConnect;
    }

    public boolean isMobileConnect() {
        return mobileConnect;
    }

    public void setMobileConnect(boolean mobileConnect) {
        this.mobileConnect = mobileConnect;
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

    public boolean isMonday() {
        return isMonday;
    }

    public void setMonday(boolean monday) {
        isMonday = monday;
    }

    public boolean isThesday() {
        return isThesday;
    }

    public void setThesday(boolean thesday) {
        isThesday = thesday;
    }

    public boolean isWednesday() {
        return isWednesday;
    }

    public void setWednesday(boolean wednesday) {
        isWednesday = wednesday;
    }

    public boolean isThursday() {
        return isThursday;
    }

    public void setThursday(boolean thursday) {
        isThursday = thursday;
    }

    public boolean isFriday() {
        return isFriday;
    }

    public void setFriday(boolean friday) {
        isFriday = friday;
    }

    public boolean isSaturday() {
        return isSaturday;
    }

    public void setSaturday(boolean saturday) {
        isSaturday = saturday;
    }

    public boolean isSunday() {
        return isSunday;
    }

    public void setSunday(boolean sunday) {
        isSunday = sunday;
    }

    public boolean isJanuary() {
        return isJanuary;
    }

    public void setJanuary(boolean january) {
        isJanuary = january;
    }

    public boolean isFebruary() {
        return isFebruary;
    }

    public void setFebruary(boolean february) {
        isFebruary = february;
    }

    public boolean isMarch() {
        return isMarch;
    }

    public void setMarch(boolean march) {
        isMarch = march;
    }

    public boolean isApril() {
        return isApril;
    }

    public void setApril(boolean april) {
        isApril = april;
    }

    public boolean isMay() {
        return isMay;
    }

    public void setMay(boolean may) {
        isMay = may;
    }

    public boolean isJune() {
        return isJune;
    }

    public void setJune(boolean june) {
        isJune = june;
    }

    public boolean isJuly() {
        return isJuly;
    }

    public void setJuly(boolean july) {
        isJuly = july;
    }

    public boolean isAugust() {
        return isAugust;
    }

    public void setAugust(boolean august) {
        isAugust = august;
    }

    public boolean isSeptember() {
        return isSeptember;
    }

    public void setSeptember(boolean september) {
        isSeptember = september;
    }

    public boolean isOctober() {
        return isOctober;
    }

    public void setOctober(boolean october) {
        isOctober = october;
    }

    public boolean isNovember() {
        return isNovember;
    }

    public void setNovember(boolean november) {
        isNovember = november;
    }

    public boolean isDecember() {
        return isDecember;
    }

    public void setDecember(boolean december) {
        isDecember = december;
    }

    public boolean isZero() {
        return isZero;
    }

    public void setZero(boolean zero) {
        isZero = zero;
    }

    public boolean isOne() {
        return isOne;
    }

    public void setOne(boolean one) {
        isOne = one;
    }

    public boolean isTwo() {
        return isTwo;
    }

    public void setTwo(boolean two) {
        isTwo = two;
    }

    public boolean isThree() {
        return isThree;
    }

    public void setThree(boolean three) {
        isThree = three;
    }

    public boolean isFour() {
        return isFour;
    }

    public void setFour(boolean four) {
        isFour = four;
    }

    public boolean isFive() {
        return isFive;
    }

    public void setFive(boolean five) {
        isFive = five;
    }

    public boolean isSix() {
        return isSix;
    }

    public void setSix(boolean six) {
        isSix = six;
    }

    public boolean isSeven() {
        return isSeven;
    }

    public void setSeven(boolean seven) {
        isSeven = seven;
    }

    public boolean isEight() {
        return isEight;
    }

    public void setEight(boolean eight) {
        isEight = eight;
    }

    public boolean isNine() {
        return isNine;
    }

    public void setNine(boolean nine) {
        isNine = nine;
    }

    public boolean isTen() {
        return isTen;
    }

    public void setTen(boolean ten) {
        isTen = ten;
    }

    public boolean isEleven() {
        return isEleven;
    }

    public void setEleven(boolean eleven) {
        isEleven = eleven;
    }

    public boolean isTwelve() {
        return isTwelve;
    }

    public void setTwelve(boolean twelve) {
        isTwelve = twelve;
    }

    public boolean isThirteen() {
        return isThirteen;
    }

    public void setThirteen(boolean thirteen) {
        isThirteen = thirteen;
    }

    public boolean isForteen() {
        return isForteen;
    }

    public void setForteen(boolean forteen) {
        isForteen = forteen;
    }

    public boolean isFifteen() {
        return isFifteen;
    }

    public void setFifteen(boolean fifteen) {
        isFifteen = fifteen;
    }

    public boolean isSixteen() {
        return isSixteen;
    }

    public void setSixteen(boolean sixteen) {
        isSixteen = sixteen;
    }

    public boolean isSeveteen() {
        return isSeveteen;
    }

    public void setSeveteen(boolean seveteen) {
        isSeveteen = seveteen;
    }

    public boolean isEighteen() {
        return isEighteen;
    }

    public void setEighteen(boolean eighteen) {
        isEighteen = eighteen;
    }

    public boolean isNineteen() {
        return isNineteen;
    }

    public void setNineteen(boolean nineteen) {
        isNineteen = nineteen;
    }

    public boolean isTwenty() {
        return isTwenty;
    }

    public void setTwenty(boolean twenty) {
        isTwenty = twenty;
    }

    public boolean isTwentyone() {
        return isTwentyone;
    }

    public void setTwentyone(boolean twentyone) {
        isTwentyone = twentyone;
    }

    public boolean isTwentytwo() {
        return isTwentytwo;
    }

    public void setTwentytwo(boolean twentytwo) {
        isTwentytwo = twentytwo;
    }

    public boolean isTwentthree() {
        return isTwentthree;
    }

    public void setTwentthree(boolean twentthree) {
        isTwentthree = twentthree;
    }

    public boolean isMonning() {
        return isMonning;
    }

    public void setMonning(boolean monning) {
        isMonning = monning;
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

    public boolean isWorkday() {
        return isWorkday;
    }

    public void setWorkday(boolean workday) {
        isWorkday = workday;
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

    public TrainDataItem(@NotNull AppType appType, @NotNull User userBehavior) {
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

        this.wifiConnect = userBehavior.getWifiConnect();

        this.mobileConnect = userBehavior.getMobileConnect();

        this.latitude = userBehavior.getLatitude();

        this.longtitude = userBehavior.getLongtitude();

        this.isMonday = userBehavior.getIsMonday();

        this.isThesday = userBehavior.getIsThesday();

        this.isWednesday = userBehavior.getIsWednesday();

        this.isThursday = userBehavior.getIsThursday();

        this.isFriday = userBehavior.getIsFriday();

        this.isSaturday = userBehavior.getIsSaturday();

        this.isSunday = userBehavior.getIsSunday();

        this.isJanuary = userBehavior.getIsJanuary();

        this.isFebruary = userBehavior.getIsFebruary();

        this.isMarch = userBehavior.getIsMarch();

        this.isApril = userBehavior.getIsApril();

        this.isMay = userBehavior.getIsMay();


        this.isJune = userBehavior.getIsJune();

        this.isJuly = userBehavior.getIsJuly();

        this.isAugust = userBehavior.getIsAugust();

        this.isSeptember = userBehavior.getIsSeptember();

        this.isOctober = userBehavior.getIsOctober();

        this.isNovember = userBehavior.getIsNovember();

        this.isDecember = userBehavior.getIsDecember();

        this.isZero = userBehavior.getIsZero();

        this.isOne = userBehavior.getIsOne();

        this.isTwo = userBehavior.getIsTwo();

        this.isThree = userBehavior.getIsThree();

        this.isFour = userBehavior.getIsFour();

        this.isFive = userBehavior.getIsFive();

        this.isSix = userBehavior.getIsSix();

        this.isSeven = userBehavior.getIsSeven();

        this.isEight = userBehavior.getIsEight();

        this.isNine = userBehavior.getIsNine();

        this.isTen = userBehavior.getIsTen();

        this.isEleven = userBehavior.getIsEleven();

        this.isTwelve = userBehavior.getIsTwelve();

        this.isThirteen = userBehavior.getIsThirteen();

        this.isForteen = userBehavior.getIsForteen();

        this.isFifteen = userBehavior.getIsFifteen();

        this.isSixteen = userBehavior.getIsSixteen();

        this.isSeveteen = userBehavior.getIsSeveteen();

        this.isEighteen = userBehavior.getIsEighteen();

        this.isNineteen = userBehavior.getIsNineteen();

        this.isTwenty = userBehavior.getIsTwenty();

        this.isTwentyone = userBehavior.getIsTwentyone();

        this.isTwentytwo = userBehavior.getIsTwentytwo();

        this.isTwentthree = userBehavior.getIsTwentthree();

        this.isMonning = userBehavior.getIsMonning();

        this.isNoon = userBehavior.getIsNoon();

        this.isAfternoon = userBehavior.getIsAfternoon();

        this.isEvening = userBehavior.getIsEvening();

        this.isNight = userBehavior.getIsNight();

        this.isBeginOfMouth = userBehavior.getIsBeginOfMouth();

        this.isEndOfMouth = userBehavior.getIsEndOfMouth();

        this.isWorkday = userBehavior.getIsWorkday();

        this.isWeekend = userBehavior.getIsWeekend();
    }

    private String separator = ",";

//    @Override
//    public String toString() {
//        List<ModelValueUtils.ClassInfo> filedsInfo = ModelValueUtils.getFiledsInfo(this);
//        StringBuilder sb = new StringBuilder(id.toString() + separator);
//        for (ModelValueUtils.ClassInfo field : filedsInfo) {
//            if (!field.getName().equals("id")) {
//                sb.append(field.getValue().toString() + separator);
//            }
//        }
//        return sb.substring(0, sb.length() - 1);
//    }


}
