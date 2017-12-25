package com.android.predict.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "PACKAGENAME")
    private String packageName;
    @Property(nameInDb = "DATE")
    private long date;
    @Property(nameInDb = "WIFICONNECT")
    private boolean wifiConnect;
    @Property(nameInDb = "mobileconnect")
    private boolean mobileConnect;
    @Property(nameInDb = "LATITUDE")
    private double latitude;
    @Property(nameInDb = "LONGTITUDE")
    private double longtitude;
    @Property(nameInDb = "ISMONDAY")
    private boolean isMonday;
    @Property(nameInDb = "ISTHESDAY")
    private boolean isThesday;
    @Property(nameInDb = "ISWEDNESDAY")
    private boolean isWednesday;
    @Property(nameInDb = "ISTHURSDAY")
    private boolean isThursday;
    @Property(nameInDb = "ISTFRIDAY")
    private boolean isFriday;
    @Property(nameInDb = "ISSATURDAY")
    private boolean isSaturday;
    @Property(nameInDb = "ISSUNDAY")
    private boolean isSunday;
    @Property(nameInDb = "ISJANUARY")
    private boolean isJanuary;
    @Property(nameInDb = "ISFEBRUARY")
    private boolean isFebruary;
    @Property(nameInDb = "ISMARCH")
    private boolean isMarch;
    @Property(nameInDb = "ISAPRIL")
    private boolean isApril;
    @Property(nameInDb = "ISMAY")
    private boolean isMay;
    @Property(nameInDb = "ISJUNE")
    private boolean isJune;
    @Property(nameInDb = "ISJULY")
    private boolean isJuly;
    @Property(nameInDb = "ISAUGUST")
    private boolean isAugust;
    @Property(nameInDb = "ISSEPTEMBER")
    private boolean isSeptember;
    @Property(nameInDb = "ISOCTOBER")
    private boolean isOctober;
    @Property(nameInDb = "ISNOVEMBER")
    private boolean isNovember;
    @Property(nameInDb = "ISDECEMBER")
    private boolean isDecember;
    @Property(nameInDb = "ISZERO")
    private boolean isZero;
    @Property(nameInDb = "ISONE")
    private boolean isOne;
    @Property(nameInDb = "ISTWO")
    private boolean isTwo;
    @Property(nameInDb = "ISTHREE")
    private boolean isThree;
    @Property(nameInDb = "ISFOUR")
    private boolean isFour;
    @Property(nameInDb = "ISFive")
    private boolean isFive;
    @Property(nameInDb = "ISSIX")
    private boolean isSix;
    @Property(nameInDb = "ISSEVEN")
    private boolean isSeven;
    @Property(nameInDb = "ISEIGHT")
    private boolean isEight;
    @Property(nameInDb = "ISNine")
    private boolean isNine;
    @Property(nameInDb = "ISTEN")
    private boolean isTen;
    @Property(nameInDb = "ISELEVEN")
    private boolean isEleven;
    @Property(nameInDb = "ISTWELVE")
    private boolean isTwelve;
    @Property(nameInDb = "ISTHIRTEEN")
    private boolean isThirteen;
    @Property(nameInDb = "ISFORTEEN")
    private boolean isForteen;
    @Property(nameInDb = "ISFIFTEEN")
    private boolean isFifteen;
    @Property(nameInDb = "ISSIXTEEN")
    private boolean isSixteen;
    @Property(nameInDb = "ISSEVETEEN")
    private boolean isSeveteen;
    @Property(nameInDb = "ISEIGHTEEN")
    private boolean isEighteen;
    @Property(nameInDb = "ISnineteen")
    private boolean isNineteen;
    @Property(nameInDb = "ISTWENTY")
    private boolean isTwenty;
    @Property(nameInDb = "ISTWENTY_ONE")
    private boolean isTwentyone;
    @Property(nameInDb = "ISTWENTY_TWO")
    private boolean isTwentytwo;
    @Property(nameInDb = "ISTWENTY_THREE")
    private boolean isTwentthree;
    @Property(nameInDb = "ISMOMNING")
    private boolean isMonning;
    @Property(nameInDb = "ISNOON")
    private boolean isNoon;
    @Property(nameInDb = "ISAFTERNOON")
    private boolean isAfternoon;
    @Property(nameInDb = "ISEVENING")
    private boolean isEvening;
    @Property(nameInDb = "ISNIGHT")
    private boolean isNight;
    @Property(nameInDb = "ISBEGINOFMOUTH")
    private boolean isBeginOfMouth;
    @Property(nameInDb = "ISENDOFMOUTH")
    private boolean isEndOfMouth;
    @Property(nameInDb = "ISWORKDAY")
    private boolean isWorkday;
    @Property(nameInDb = "ISWEEKEND")
    private boolean isWeekend;
    @Generated(hash = 934061749)
    public User(Long id, String packageName, long date, boolean wifiConnect,
            boolean mobileConnect, double latitude, double longtitude,
            boolean isMonday, boolean isThesday, boolean isWednesday,
            boolean isThursday, boolean isFriday, boolean isSaturday,
            boolean isSunday, boolean isJanuary, boolean isFebruary,
            boolean isMarch, boolean isApril, boolean isMay, boolean isJune,
            boolean isJuly, boolean isAugust, boolean isSeptember,
            boolean isOctober, boolean isNovember, boolean isDecember,
            boolean isZero, boolean isOne, boolean isTwo, boolean isThree,
            boolean isFour, boolean isFive, boolean isSix, boolean isSeven,
            boolean isEight, boolean isNine, boolean isTen, boolean isEleven,
            boolean isTwelve, boolean isThirteen, boolean isForteen,
            boolean isFifteen, boolean isSixteen, boolean isSeveteen,
            boolean isEighteen, boolean isNineteen, boolean isTwenty,
            boolean isTwentyone, boolean isTwentytwo, boolean isTwentthree,
            boolean isMonning, boolean isNoon, boolean isAfternoon,
            boolean isEvening, boolean isNight, boolean isBeginOfMouth,
            boolean isEndOfMouth, boolean isWorkday, boolean isWeekend) {
        this.id = id;
        this.packageName = packageName;
        this.date = date;
        this.wifiConnect = wifiConnect;
        this.mobileConnect = mobileConnect;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.isMonday = isMonday;
        this.isThesday = isThesday;
        this.isWednesday = isWednesday;
        this.isThursday = isThursday;
        this.isFriday = isFriday;
        this.isSaturday = isSaturday;
        this.isSunday = isSunday;
        this.isJanuary = isJanuary;
        this.isFebruary = isFebruary;
        this.isMarch = isMarch;
        this.isApril = isApril;
        this.isMay = isMay;
        this.isJune = isJune;
        this.isJuly = isJuly;
        this.isAugust = isAugust;
        this.isSeptember = isSeptember;
        this.isOctober = isOctober;
        this.isNovember = isNovember;
        this.isDecember = isDecember;
        this.isZero = isZero;
        this.isOne = isOne;
        this.isTwo = isTwo;
        this.isThree = isThree;
        this.isFour = isFour;
        this.isFive = isFive;
        this.isSix = isSix;
        this.isSeven = isSeven;
        this.isEight = isEight;
        this.isNine = isNine;
        this.isTen = isTen;
        this.isEleven = isEleven;
        this.isTwelve = isTwelve;
        this.isThirteen = isThirteen;
        this.isForteen = isForteen;
        this.isFifteen = isFifteen;
        this.isSixteen = isSixteen;
        this.isSeveteen = isSeveteen;
        this.isEighteen = isEighteen;
        this.isNineteen = isNineteen;
        this.isTwenty = isTwenty;
        this.isTwentyone = isTwentyone;
        this.isTwentytwo = isTwentytwo;
        this.isTwentthree = isTwentthree;
        this.isMonning = isMonning;
        this.isNoon = isNoon;
        this.isAfternoon = isAfternoon;
        this.isEvening = isEvening;
        this.isNight = isNight;
        this.isBeginOfMouth = isBeginOfMouth;
        this.isEndOfMouth = isEndOfMouth;
        this.isWorkday = isWorkday;
        this.isWeekend = isWeekend;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPackageName() {
        return this.packageName;
    }
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    public long getDate() {
        return this.date;
    }
    public void setDate(long date) {
        this.date = date;
    }
    public boolean getWifiConnect() {
        return this.wifiConnect;
    }
    public void setWifiConnect(boolean wifiConnect) {
        this.wifiConnect = wifiConnect;
    }
    public boolean getMobileConnect() {
        return this.mobileConnect;
    }
    public void setMobileConnect(boolean mobileConnect) {
        this.mobileConnect = mobileConnect;
    }
    public double getLatitude() {
        return this.latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongtitude() {
        return this.longtitude;
    }
    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }
    public boolean getIsMonday() {
        return this.isMonday;
    }
    public void setIsMonday(boolean isMonday) {
        this.isMonday = isMonday;
    }
    public boolean getIsThesday() {
        return this.isThesday;
    }
    public void setIsThesday(boolean isThesday) {
        this.isThesday = isThesday;
    }
    public boolean getIsWednesday() {
        return this.isWednesday;
    }
    public void setIsWednesday(boolean isWednesday) {
        this.isWednesday = isWednesday;
    }
    public boolean getIsThursday() {
        return this.isThursday;
    }
    public void setIsThursday(boolean isThursday) {
        this.isThursday = isThursday;
    }
    public boolean getIsFriday() {
        return this.isFriday;
    }
    public void setIsFriday(boolean isFriday) {
        this.isFriday = isFriday;
    }
    public boolean getIsSaturday() {
        return this.isSaturday;
    }
    public void setIsSaturday(boolean isSaturday) {
        this.isSaturday = isSaturday;
    }
    public boolean getIsSunday() {
        return this.isSunday;
    }
    public void setIsSunday(boolean isSunday) {
        this.isSunday = isSunday;
    }
    public boolean getIsJanuary() {
        return this.isJanuary;
    }
    public void setIsJanuary(boolean isJanuary) {
        this.isJanuary = isJanuary;
    }
    public boolean getIsFebruary() {
        return this.isFebruary;
    }
    public void setIsFebruary(boolean isFebruary) {
        this.isFebruary = isFebruary;
    }
    public boolean getIsMarch() {
        return this.isMarch;
    }
    public void setIsMarch(boolean isMarch) {
        this.isMarch = isMarch;
    }
    public boolean getIsApril() {
        return this.isApril;
    }
    public void setIsApril(boolean isApril) {
        this.isApril = isApril;
    }
    public boolean getIsMay() {
        return this.isMay;
    }
    public void setIsMay(boolean isMay) {
        this.isMay = isMay;
    }
    public boolean getIsJune() {
        return this.isJune;
    }
    public void setIsJune(boolean isJune) {
        this.isJune = isJune;
    }
    public boolean getIsJuly() {
        return this.isJuly;
    }
    public void setIsJuly(boolean isJuly) {
        this.isJuly = isJuly;
    }
    public boolean getIsAugust() {
        return this.isAugust;
    }
    public void setIsAugust(boolean isAugust) {
        this.isAugust = isAugust;
    }
    public boolean getIsSeptember() {
        return this.isSeptember;
    }
    public void setIsSeptember(boolean isSeptember) {
        this.isSeptember = isSeptember;
    }
    public boolean getIsOctober() {
        return this.isOctober;
    }
    public void setIsOctober(boolean isOctober) {
        this.isOctober = isOctober;
    }
    public boolean getIsNovember() {
        return this.isNovember;
    }
    public void setIsNovember(boolean isNovember) {
        this.isNovember = isNovember;
    }
    public boolean getIsDecember() {
        return this.isDecember;
    }
    public void setIsDecember(boolean isDecember) {
        this.isDecember = isDecember;
    }
    public boolean getIsZero() {
        return this.isZero;
    }
    public void setIsZero(boolean isZero) {
        this.isZero = isZero;
    }
    public boolean getIsOne() {
        return this.isOne;
    }
    public void setIsOne(boolean isOne) {
        this.isOne = isOne;
    }
    public boolean getIsTwo() {
        return this.isTwo;
    }
    public void setIsTwo(boolean isTwo) {
        this.isTwo = isTwo;
    }
    public boolean getIsThree() {
        return this.isThree;
    }
    public void setIsThree(boolean isThree) {
        this.isThree = isThree;
    }
    public boolean getIsFour() {
        return this.isFour;
    }
    public void setIsFour(boolean isFour) {
        this.isFour = isFour;
    }
    public boolean getIsFive() {
        return this.isFive;
    }
    public void setIsFive(boolean isFive) {
        this.isFive = isFive;
    }
    public boolean getIsSix() {
        return this.isSix;
    }
    public void setIsSix(boolean isSix) {
        this.isSix = isSix;
    }
    public boolean getIsSeven() {
        return this.isSeven;
    }
    public void setIsSeven(boolean isSeven) {
        this.isSeven = isSeven;
    }
    public boolean getIsEight() {
        return this.isEight;
    }
    public void setIsEight(boolean isEight) {
        this.isEight = isEight;
    }
    public boolean getIsNine() {
        return this.isNine;
    }
    public void setIsNine(boolean isNine) {
        this.isNine = isNine;
    }
    public boolean getIsTen() {
        return this.isTen;
    }
    public void setIsTen(boolean isTen) {
        this.isTen = isTen;
    }
    public boolean getIsEleven() {
        return this.isEleven;
    }
    public void setIsEleven(boolean isEleven) {
        this.isEleven = isEleven;
    }
    public boolean getIsTwelve() {
        return this.isTwelve;
    }
    public void setIsTwelve(boolean isTwelve) {
        this.isTwelve = isTwelve;
    }
    public boolean getIsThirteen() {
        return this.isThirteen;
    }
    public void setIsThirteen(boolean isThirteen) {
        this.isThirteen = isThirteen;
    }
    public boolean getIsForteen() {
        return this.isForteen;
    }
    public void setIsForteen(boolean isForteen) {
        this.isForteen = isForteen;
    }
    public boolean getIsFifteen() {
        return this.isFifteen;
    }
    public void setIsFifteen(boolean isFifteen) {
        this.isFifteen = isFifteen;
    }
    public boolean getIsSixteen() {
        return this.isSixteen;
    }
    public void setIsSixteen(boolean isSixteen) {
        this.isSixteen = isSixteen;
    }
    public boolean getIsSeveteen() {
        return this.isSeveteen;
    }
    public void setIsSeveteen(boolean isSeveteen) {
        this.isSeveteen = isSeveteen;
    }
    public boolean getIsEighteen() {
        return this.isEighteen;
    }
    public void setIsEighteen(boolean isEighteen) {
        this.isEighteen = isEighteen;
    }
    public boolean getIsNineteen() {
        return this.isNineteen;
    }
    public void setIsNineteen(boolean isNineteen) {
        this.isNineteen = isNineteen;
    }
    public boolean getIsTwenty() {
        return this.isTwenty;
    }
    public void setIsTwenty(boolean isTwenty) {
        this.isTwenty = isTwenty;
    }
    public boolean getIsTwentyone() {
        return this.isTwentyone;
    }
    public void setIsTwentyone(boolean isTwentyone) {
        this.isTwentyone = isTwentyone;
    }
    public boolean getIsTwentytwo() {
        return this.isTwentytwo;
    }
    public void setIsTwentytwo(boolean isTwentytwo) {
        this.isTwentytwo = isTwentytwo;
    }
    public boolean getIsTwentthree() {
        return this.isTwentthree;
    }
    public void setIsTwentthree(boolean isTwentthree) {
        this.isTwentthree = isTwentthree;
    }
    public boolean getIsMonning() {
        return this.isMonning;
    }
    public void setIsMonning(boolean isMonning) {
        this.isMonning = isMonning;
    }
    public boolean getIsNoon() {
        return this.isNoon;
    }
    public void setIsNoon(boolean isNoon) {
        this.isNoon = isNoon;
    }
    public boolean getIsAfternoon() {
        return this.isAfternoon;
    }
    public void setIsAfternoon(boolean isAfternoon) {
        this.isAfternoon = isAfternoon;
    }
    public boolean getIsEvening() {
        return this.isEvening;
    }
    public void setIsEvening(boolean isEvening) {
        this.isEvening = isEvening;
    }
    public boolean getIsNight() {
        return this.isNight;
    }
    public void setIsNight(boolean isNight) {
        this.isNight = isNight;
    }
    public boolean getIsBeginOfMouth() {
        return this.isBeginOfMouth;
    }
    public void setIsBeginOfMouth(boolean isBeginOfMouth) {
        this.isBeginOfMouth = isBeginOfMouth;
    }
    public boolean getIsEndOfMouth() {
        return this.isEndOfMouth;
    }
    public void setIsEndOfMouth(boolean isEndOfMouth) {
        this.isEndOfMouth = isEndOfMouth;
    }
    public boolean getIsWorkday() {
        return this.isWorkday;
    }
    public void setIsWorkday(boolean isWorkday) {
        this.isWorkday = isWorkday;
    }
    public boolean getIsWeekend() {
        return this.isWeekend;
    }
    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }
    
}