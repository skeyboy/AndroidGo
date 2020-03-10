package com.example.logincomponent;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselibrary.service.IAppService;
import com.example.baselibrary.service.ServiceFactory;

public class LoginApplication extends Application implements IAppService {

    @Override
    public void initApp(Application mainApp) {
        ARouter.init(mainApp);
        ServiceFactory.getInstance().setLoginService(new LoginService());

    }
}
