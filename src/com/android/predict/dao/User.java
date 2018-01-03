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
    @Property(nameInDb = "ISFEBRUARY")
    private boolean isFebruary;
    @Property(nameInDb = "ISSPRING")
    private boolean isSpring;
    @Property(nameInDb = "ISSUMMER")
    private boolean isSummer;
    @Property(nameInDb = "ISAUTUMN")
    private boolean isAutumn;
    @Property(nameInDb = "ISWINTER")
    private boolean isWinter;
    @Property(nameInDb = "ISMATINAL")
    private boolean isMatinal;
    @Property(nameInDb = "ISMORNING")
    private boolean isMorning;
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
    @Property(nameInDb = "ISWEEKEND")
    private boolean isWeekend;
    @Generated(hash = 119115890)
    public User(Long id, String packageName, long date, boolean wifiConnect,
            boolean mobileConnect, double latitude, double longtitude,
            boolean isFebruary, boolean isSpring, boolean isSummer,
            boolean isAutumn, boolean isWinter, boolean isMatinal,
            boolean isMorning, boolean isNoon, boolean isAfternoon,
            boolean isEvening, boolean isNight, boolean isBeginOfMouth,
            boolean isEndOfMouth, boolean isWeekend) {
        this.id = id;
        this.packageName = packageName;
        this.date = date;
        this.wifiConnect = wifiConnect;
        this.mobileConnect = mobileConnect;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.isFebruary = isFebruary;
        this.isSpring = isSpring;
        this.isSummer = isSummer;
        this.isAutumn = isAutumn;
        this.isWinter = isWinter;
        this.isMatinal = isMatinal;
        this.isMorning = isMorning;
        this.isNoon = isNoon;
        this.isAfternoon = isAfternoon;
        this.isEvening = isEvening;
        this.isNight = isNight;
        this.isBeginOfMouth = isBeginOfMouth;
        this.isEndOfMouth = isEndOfMouth;
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
    public boolean getIsFebruary() {
        return this.isFebruary;
    }
    public void setIsFebruary(boolean isFebruary) {
        this.isFebruary = isFebruary;
    }
    public boolean getIsSpring() {
        return this.isSpring;
    }
    public void setIsSpring(boolean isSpring) {
        this.isSpring = isSpring;
    }
    public boolean getIsSummer() {
        return this.isSummer;
    }
    public void setIsSummer(boolean isSummer) {
        this.isSummer = isSummer;
    }
    public boolean getIsAutumn() {
        return this.isAutumn;
    }
    public void setIsAutumn(boolean isAutumn) {
        this.isAutumn = isAutumn;
    }
    public boolean getIsWinter() {
        return this.isWinter;
    }
    public void setIsWinter(boolean isWinter) {
        this.isWinter = isWinter;
    }
    public boolean getIsMatinal() {
        return this.isMatinal;
    }
    public void setIsMatinal(boolean isMatinal) {
        this.isMatinal = isMatinal;
    }
    public boolean getIsMorning() {
        return this.isMorning;
    }
    public void setIsMorning(boolean isMorning) {
        this.isMorning = isMorning;
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
    public boolean getIsWeekend() {
        return this.isWeekend;
    }
    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }
   
}