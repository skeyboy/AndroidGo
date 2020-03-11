package com.example.baselibrary.service;

import android.app.Application;

public interface IAppService {
    void initApp(Application mainApp);

    void initAppFinish();
}
