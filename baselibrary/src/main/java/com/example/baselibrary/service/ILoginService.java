package com.example.baselibrary.service;

import android.content.Context;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public interface ILoginService {
    void launch(Context context);

    public Fragment getFragment(FragmentManager fragmentManager, int viewId, ViewGroup root);
}
