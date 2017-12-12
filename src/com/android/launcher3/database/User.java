package com.android.launcher3.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity
public class User {  
    @Id
    private Long id;
    @Property(nameInDb = "PACKAGENAME")
    private String packageName;
    @Property(nameInDb = "DATE")
    private String date;
    @Property(nameInDb = "WIFICONNECT")
    private boolean wifiConnect;
    @Property(nameInDb = "mobileconnect")
    private boolean mobileConnect;
    @Property(nameInDb = "LATITUDE")
    private double latitude;
    @Property(nameInDb = "LONGTITUDE")
    private double longtitude;
    @Property(nameInDb = "INWORKSPACE")
    private boolean inWorkspace;
    public boolean getInWorkspace() {
        return this.inWorkspace;
    }
    public void setInWorkspace(boolean inWorkspace) {
        this.inWorkspace = inWorkspace;
    }
    public double getLongtitude() {
        return this.longtitude;
    }
    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }
    public double getLatitude() {
        return this.latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public boolean getMobileConnect() {
        return this.mobileConnect;
    }
    public void setMobileConnect(boolean mobileConnect) {
        this.mobileConnect = mobileConnect;
    }
    public boolean getWifiConnect() {
        return this.wifiConnect;
    }
    public void setWifiConnect(boolean wifiConnect) {
        this.wifiConnect = wifiConnect;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getPackageName() {
        return this.packageName;
    }
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1091862009)
    public User(Long id, String packageName, String date, boolean wifiConnect,
                boolean mobileConnect, double latitude, double longtitude,
                boolean inWorkspace) {
        this.id = id;
        this.packageName = packageName;
        this.date = date;
        this.wifiConnect = wifiConnect;
        this.mobileConnect = mobileConnect;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.inWorkspace = inWorkspace;
    }
    @Generated(hash = 586692638)
    public User() {
    }



} 