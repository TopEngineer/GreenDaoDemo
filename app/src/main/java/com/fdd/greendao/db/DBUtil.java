package com.fdd.greendao.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBUtil {
    private static final String DB_NAME = "person_db";
    private Context context;
    private static DBUtil mInstance;
    private DaoMaster.DevOpenHelper openHelper;
    private DaoSession daoSession;

    private DBUtil(Context context) {
        this.context = context;
        this.openHelper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
        DaoMaster daoMaster = new DaoMaster(this.openHelper.getWritableDatabase());
        this.daoSession = daoMaster.newSession();
    }

    public static DBUtil getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DBUtil.class) {
                if (mInstance == null) {
                    mInstance = new DBUtil(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }

    private SQLiteDatabase getWritableDataBase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }

    /*
    插入笔记
     */
    public DaoSession getDaoSession() {
        return this.daoSession;
    }

    /*
    插入笔记
     */
    public void insertNote(PersonBean meiMeiNote) {
        DaoMaster daoMaster = new DaoMaster(getWritableDataBase());
        DaoSession daoSession = daoMaster.newSession();
        PersonBeanDao meiMeiNoteDao = daoSession.getPersonBeanDao();
        meiMeiNoteDao.insert(meiMeiNote);
    }

    /*
    删除笔记
     */
    public void deleteNote(PersonBean meiMeiNote) {
        DaoMaster daoMaster = new DaoMaster(getWritableDataBase());
        DaoSession daoSession = daoMaster.newSession();
        PersonBeanDao meiMeiNoteDao = daoSession.getPersonBeanDao();
        meiMeiNoteDao.delete(meiMeiNote);
    }

    /*
    更新笔记
     */
    public void updateNote(PersonBean meiMeiNote) {
        DaoMaster daoMaster = new DaoMaster(getWritableDataBase());
        DaoSession daoSession = daoMaster.newSession();
        PersonBeanDao meiMeiNoteDao = daoSession.getPersonBeanDao();
        meiMeiNoteDao.update(meiMeiNote);
    }
    
}