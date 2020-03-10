package com.example.logincomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import org.w3c.dom.Text;

@Route(path = "/login/index")
public class LoginActivity extends AppCompatActivity {
    @Autowired(name = "mobile")
    public String mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //需要注入才能完成数据的自动装填
        ARouter.getInstance().inject(this);

        ((TextView) findViewById(R.id.mobileView)).setText(this.mobile);
    }
}
