package com.goyin.mvp.presenter.home.impl;

import com.goyin.mvp.base.BasePresenter;
import com.goyin.mvp.base.BaseView;
import com.goyin.mvp.presenter.home.interfaces.HomeContract;
import com.goyin.mvp.view.common.fragment.HomeFragment;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：
 *  备注消息：
 *  修改时间：2016/11/14 下午3:22
 **/
public class HomePresenterImp extends BasePresenter<HomeFragment> implements HomeContract.Presenter {

    @Override
    public void message(String msg) {
        mView.showSuccessWithStatus(msg);
    }
}
