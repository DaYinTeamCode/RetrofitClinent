package com.goyin.mvp.view.common.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.gaoyin.mvp.R;
import com.goyin.mvp.base.BaseActivity;
import com.goyin.mvp.view.common.fragment.HomeFragment;


public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    protected void onInitView(Bundle bundle) {
        FragmentManager manmager = getSupportFragmentManager();
        FragmentTransaction transaction = manmager.beginTransaction();
        HomeFragment fragment=new HomeFragment();
        transaction.replace(R.id.main_content,fragment);

    }
    @Override
    protected void onEvent() {

    }

    @Override
    protected Class getContractClazz() {
        return null;
    }



}
