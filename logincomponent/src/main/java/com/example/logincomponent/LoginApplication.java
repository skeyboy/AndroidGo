package com.example.logincomponent;

import android.app.Application;

import com.example.baselibrary.service.IAppService;
import com.example.baselibrary.service.ServiceFactory;

public class LoginApplication extends Application implements IAppService {

    @Override
    public void initApp(Application mainApp) {
        ServiceFactory.getInstance().setLoginService(new LoginService());

    }
}
