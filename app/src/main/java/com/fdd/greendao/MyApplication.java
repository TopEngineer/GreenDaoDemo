package com.fdd.greendao;

import android.app.Application;

import com.fdd.greendao.db.DBUtil;

/**
 * Created by fdd on 2017-12-06.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DBUtil.getInstance(this);
    }
}
