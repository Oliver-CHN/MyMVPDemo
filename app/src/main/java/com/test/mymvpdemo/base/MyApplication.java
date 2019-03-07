package com.test.mymvpdemo.base;

import android.app.Application;

import com.kingja.loadsir.core.LoadSir;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LoadSir.beginBuilder()
                .addCallback(new LoadingCallback())
                .addCallback(new NetworkErrorCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();
    }
}
