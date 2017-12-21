package com.android.launcher3.predict.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by orien on 2017/12/14.
 */
@Entity
public class AppType {

    @Id
    private Long id;
    @Property(nameInDb = "PACKAGENAME")
    private String packageName;
    @Property(nameInDb = "APPTYPE")
    private int appType;
    @Property(nameInDb = "ISBROWSER")
    public boolean isBrowser;
    @Property(nameInDb = "ISEFFICIENCY")
    public boolean isEfficiency;
    @Property(nameInDb = "ISGAME")
    public boolean isGame;
    @Property(nameInDb = "ISIM")
    public boolean isIm;
    @Property(nameInDb = "ISMEDIA")
    public boolean isMedia;
    @Property(nameInDb = "ISPAY")
    public boolean isPay;
    @Property(nameInDb = "ISREAD")
    public boolean isRead;
    @Property(nameInDb = "ISSHOP")
    public boolean isShop;
    @Property(nameInDb = "ISSPORT")
    public boolean isSport;
    @Property(nameInDb = "ISSTOCK")
    public boolean isStock;
    @Property(nameInDb = "ISSTUDY")
    public boolean isStudy;
    @Property(nameInDb = "ISTRAVEL")
    public boolean isTravel;
    @Generated(hash = 762047924)
    public AppType(Long id, String packageName, int appType, boolean isBrowser,
            boolean isEfficiency, boolean isGame, boolean isIm, boolean isMedia,
            boolean isPay, boolean isRead, boolean isShop, boolean isSport,
            boolean isStock, boolean isStudy, boolean isTravel) {
        this.id = id;
        this.packageName = packageName;
        this.appType = appType;
        this.isBrowser = isBrowser;
        this.isEfficiency = isEfficiency;
        this.isGame = isGame;
        this.isIm = isIm;
        this.isMedia = isMedia;
        this.isPay = isPay;
        this.isRead = isRead;
        this.isShop = isShop;
        this.isSport = isSport;
        this.isStock = isStock;
        this.isStudy = isStudy;
        this.isTravel = isTravel;
    }
    @Generated(hash = 1464568658)
    public AppType() {
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
    public int getAppType() {
        return this.appType;
    }
    public void setAppType(int appType) {
        this.appType = appType;
    }
    public boolean getIsBrowser() {
        return this.isBrowser;
    }
    public void setIsBrowser(boolean isBrowser) {
        this.isBrowser = isBrowser;
    }
    public boolean getIsEfficiency() {
        return this.isEfficiency;
    }
    public void setIsEfficiency(boolean isEfficiency) {
        this.isEfficiency = isEfficiency;
    }
    public boolean getIsGame() {
        return this.isGame;
    }
    public void setIsGame(boolean isGame) {
        this.isGame = isGame;
    }
    public boolean getIsIm() {
        return this.isIm;
    }
    public void setIsIm(boolean isIm) {
        this.isIm = isIm;
    }
    public boolean getIsMedia() {
        return this.isMedia;
    }
    public void setIsMedia(boolean isMedia) {
        this.isMedia = isMedia;
    }
    public boolean getIsPay() {
        return this.isPay;
    }
    public void setIsPay(boolean isPay) {
        this.isPay = isPay;
    }
    public boolean getIsRead() {
        return this.isRead;
    }
    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }
    public boolean getIsShop() {
        return this.isShop;
    }
    public void setIsShop(boolean isShop) {
        this.isShop = isShop;
    }
    public boolean getIsSport() {
        return this.isSport;
    }
    public void setIsSport(boolean isSport) {
        this.isSport = isSport;
    }
    public boolean getIsStock() {
        return this.isStock;
    }
    public void setIsStock(boolean isStock) {
        this.isStock = isStock;
    }
    public boolean getIsStudy() {
        return this.isStudy;
    }
    public void setIsStudy(boolean isStudy) {
        this.isStudy = isStudy;
    }
    public boolean getIsTravel() {
        return this.isTravel;
    }
    public void setIsTravel(boolean isTravel) {
        this.isTravel = isTravel;
    }

}
