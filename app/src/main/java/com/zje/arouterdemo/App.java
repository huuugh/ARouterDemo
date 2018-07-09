package com.zje.arouterdemo;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by Hugh on 2018/7/9.
 *
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        boolean isDebug = true;
        
        if (isDebug) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
