package com.example.androidgo;

import android.app.Application;

import com.example.baselibrary.service.IAppService;
import com.example.baselibrary.service.config.AppConfig;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        for (String component : AppConfig.APP_COMPONENTS) {
            try {
                Class<?> aClass = Class.forName(component);
                Object object = aClass.newInstance();
                IAppService iAppService = (IAppService) object;
                iAppService.initApp(this);
                iAppService.initAppFinish();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
