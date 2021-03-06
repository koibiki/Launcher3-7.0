package com.android.predict.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "APP_TYPE".
*/
public class AppTypeDao extends AbstractDao<AppType, Long> {

    public static final String TABLENAME = "APP_TYPE";

    /**
     * Properties of entity AppType.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property PackageName = new Property(1, String.class, "packageName", false, "PACKAGENAME");
        public final static Property IsBrowser = new Property(2, boolean.class, "isBrowser", false, "ISBROWSER");
        public final static Property IsEfficiency = new Property(3, boolean.class, "isEfficiency", false, "ISEFFICIENCY");
        public final static Property IsGame = new Property(4, boolean.class, "isGame", false, "ISGAME");
        public final static Property IsIm = new Property(5, boolean.class, "isIm", false, "ISIM");
        public final static Property IsMedia = new Property(6, boolean.class, "isMedia", false, "ISMEDIA");
        public final static Property IsPay = new Property(7, boolean.class, "isPay", false, "ISPAY");
        public final static Property IsRead = new Property(8, boolean.class, "isRead", false, "ISREAD");
        public final static Property IsShop = new Property(9, boolean.class, "isShop", false, "ISSHOP");
        public final static Property IsSport = new Property(10, boolean.class, "isSport", false, "ISSPORT");
        public final static Property IsStock = new Property(11, boolean.class, "isStock", false, "ISSTOCK");
        public final static Property IsStudy = new Property(12, boolean.class, "isStudy", false, "ISSTUDY");
        public final static Property IsTravel = new Property(13, boolean.class, "isTravel", false, "ISTRAVEL");
        public final static Property IsO2o = new Property(14, boolean.class, "isO2o", false, "ISO2O");
    }


    public AppTypeDao(DaoConfig config) {
        super(config);
    }
    
    public AppTypeDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"APP_TYPE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"PACKAGENAME\" TEXT," + // 1: packageName
                "\"ISBROWSER\" INTEGER NOT NULL ," + // 2: isBrowser
                "\"ISEFFICIENCY\" INTEGER NOT NULL ," + // 3: isEfficiency
                "\"ISGAME\" INTEGER NOT NULL ," + // 4: isGame
                "\"ISIM\" INTEGER NOT NULL ," + // 5: isIm
                "\"ISMEDIA\" INTEGER NOT NULL ," + // 6: isMedia
                "\"ISPAY\" INTEGER NOT NULL ," + // 7: isPay
                "\"ISREAD\" INTEGER NOT NULL ," + // 8: isRead
                "\"ISSHOP\" INTEGER NOT NULL ," + // 9: isShop
                "\"ISSPORT\" INTEGER NOT NULL ," + // 10: isSport
                "\"ISSTOCK\" INTEGER NOT NULL ," + // 11: isStock
                "\"ISSTUDY\" INTEGER NOT NULL ," + // 12: isStudy
                "\"ISTRAVEL\" INTEGER NOT NULL ," + // 13: isTravel
                "\"ISO2O\" INTEGER NOT NULL );"); // 14: isO2o
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"APP_TYPE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, AppType entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String packageName = entity.getPackageName();
        if (packageName != null) {
            stmt.bindString(2, packageName);
        }
        stmt.bindLong(3, entity.getIsBrowser() ? 1L: 0L);
        stmt.bindLong(4, entity.getIsEfficiency() ? 1L: 0L);
        stmt.bindLong(5, entity.getIsGame() ? 1L: 0L);
        stmt.bindLong(6, entity.getIsIm() ? 1L: 0L);
        stmt.bindLong(7, entity.getIsMedia() ? 1L: 0L);
        stmt.bindLong(8, entity.getIsPay() ? 1L: 0L);
        stmt.bindLong(9, entity.getIsRead() ? 1L: 0L);
        stmt.bindLong(10, entity.getIsShop() ? 1L: 0L);
        stmt.bindLong(11, entity.getIsSport() ? 1L: 0L);
        stmt.bindLong(12, entity.getIsStock() ? 1L: 0L);
        stmt.bindLong(13, entity.getIsStudy() ? 1L: 0L);
        stmt.bindLong(14, entity.getIsTravel() ? 1L: 0L);
        stmt.bindLong(15, entity.getIsO2o() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, AppType entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String packageName = entity.getPackageName();
        if (packageName != null) {
            stmt.bindString(2, packageName);
        }
        stmt.bindLong(3, entity.getIsBrowser() ? 1L: 0L);
        stmt.bindLong(4, entity.getIsEfficiency() ? 1L: 0L);
        stmt.bindLong(5, entity.getIsGame() ? 1L: 0L);
        stmt.bindLong(6, entity.getIsIm() ? 1L: 0L);
        stmt.bindLong(7, entity.getIsMedia() ? 1L: 0L);
        stmt.bindLong(8, entity.getIsPay() ? 1L: 0L);
        stmt.bindLong(9, entity.getIsRead() ? 1L: 0L);
        stmt.bindLong(10, entity.getIsShop() ? 1L: 0L);
        stmt.bindLong(11, entity.getIsSport() ? 1L: 0L);
        stmt.bindLong(12, entity.getIsStock() ? 1L: 0L);
        stmt.bindLong(13, entity.getIsStudy() ? 1L: 0L);
        stmt.bindLong(14, entity.getIsTravel() ? 1L: 0L);
        stmt.bindLong(15, entity.getIsO2o() ? 1L: 0L);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public AppType readEntity(Cursor cursor, int offset) {
        AppType entity = new AppType( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // packageName
            cursor.getShort(offset + 2) != 0, // isBrowser
            cursor.getShort(offset + 3) != 0, // isEfficiency
            cursor.getShort(offset + 4) != 0, // isGame
            cursor.getShort(offset + 5) != 0, // isIm
            cursor.getShort(offset + 6) != 0, // isMedia
            cursor.getShort(offset + 7) != 0, // isPay
            cursor.getShort(offset + 8) != 0, // isRead
            cursor.getShort(offset + 9) != 0, // isShop
            cursor.getShort(offset + 10) != 0, // isSport
            cursor.getShort(offset + 11) != 0, // isStock
            cursor.getShort(offset + 12) != 0, // isStudy
            cursor.getShort(offset + 13) != 0, // isTravel
            cursor.getShort(offset + 14) != 0 // isO2o
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, AppType entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPackageName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setIsBrowser(cursor.getShort(offset + 2) != 0);
        entity.setIsEfficiency(cursor.getShort(offset + 3) != 0);
        entity.setIsGame(cursor.getShort(offset + 4) != 0);
        entity.setIsIm(cursor.getShort(offset + 5) != 0);
        entity.setIsMedia(cursor.getShort(offset + 6) != 0);
        entity.setIsPay(cursor.getShort(offset + 7) != 0);
        entity.setIsRead(cursor.getShort(offset + 8) != 0);
        entity.setIsShop(cursor.getShort(offset + 9) != 0);
        entity.setIsSport(cursor.getShort(offset + 10) != 0);
        entity.setIsStock(cursor.getShort(offset + 11) != 0);
        entity.setIsStudy(cursor.getShort(offset + 12) != 0);
        entity.setIsTravel(cursor.getShort(offset + 13) != 0);
        entity.setIsO2o(cursor.getShort(offset + 14) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(AppType entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(AppType entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(AppType entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
