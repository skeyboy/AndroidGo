package com.example.logincomponent;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.baselibrary.service.ILoginService;

public class LoginService implements ILoginService {
    @Override
    public void launch(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    public Fragment getFragment(FragmentManager fragmentManager, int viewId, ViewGroup root) {

        return null;
    }
}
