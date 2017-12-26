package com.android.predict.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by orien on 2017/12/14.
 */
@Entity
public class AppType {

    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "PACKAGENAME")
    private String packageName;
    @Property(nameInDb = "ISBROWSER")
    private boolean isBrowser;
    @Property(nameInDb = "ISEFFICIENCY")
    private boolean isEfficiency;
    @Property(nameInDb = "ISGAME")
    private boolean isGame;
    @Property(nameInDb = "ISIM")
    private boolean isIm;
    @Property(nameInDb = "ISMEDIA")
    private boolean isMedia;
    @Property(nameInDb = "ISPAY")
    private boolean isPay;
    @Property(nameInDb = "ISREAD")
    private boolean isRead;
    @Property(nameInDb = "ISSHOP")
    private boolean isShop;
    @Property(nameInDb = "ISSPORT")
    private boolean isSport;
    @Property(nameInDb = "ISSTOCK")
    private boolean isStock;
    @Property(nameInDb = "ISSTUDY")
    private boolean isStudy;
    @Property(nameInDb = "ISTRAVEL")
    private boolean isTravel;
    @Property(nameInDb = "ISO2O")
    private boolean isO2o;
    @Generated(hash = 676283195)
    public AppType(Long id, String packageName, boolean isBrowser,
            boolean isEfficiency, boolean isGame, boolean isIm, boolean isMedia,
            boolean isPay, boolean isRead, boolean isShop, boolean isSport,
            boolean isStock, boolean isStudy, boolean isTravel, boolean isO2o) {
        this.id = id;
        this.packageName = packageName;
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
        this.isO2o = isO2o;
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
    public boolean getIsO2o() {
        return this.isO2o;
    }
    public void setIsO2o(boolean isO2o) {
        this.isO2o = isO2o;
    }
    

}
