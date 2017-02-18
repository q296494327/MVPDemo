package com.explam.mvpdemo.base;

import android.app.Application;

import com.lzy.okgo.OkGo;

/**
 * User: xiemiao
 * Date: 2017-02-18
 * Time: 19:51
 * Desc:
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkGo.init(this);
    }
}
