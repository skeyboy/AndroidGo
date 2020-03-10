package com.example.androidgo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselibrary.service.ServiceFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchLogin(View view) {
//        参考https://github.com/alibaba/ARouter
        ARouter.getInstance().build("/login/index").withString("mobile", "1362x0194xx").navigation();
        /*可以回传数据
ARouter.getInstance().build("").navigation(this, 12, new NavigationCallback() {
    @Override
    public void onFound(Postcard postcard) {

    }

    @Override
    public void onLost(Postcard postcard) {

    }

    @Override
    public void onArrival(Postcard postcard) {

    }

    @Override
    public void onInterrupt(Postcard postcard) {

    }
});
*/
//        ServiceFactory.getInstance()
//                .getLoginService()
//                .launch(this);
    }
}
