package com.goyin.mvp.view.common.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.gaoyin.mvp.R;
import com.goyin.mvp.base.BaseFragment;
import com.goyin.mvp.presenter.home.impl.HomePresenterImp;
import com.goyin.mvp.presenter.home.interfaces.HomeContract;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：gaoyin
 * 电话：18810474975
 * 邮箱：18810474975@163.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 修改时间：2016/11/14 上午11:50
 **/
public class HomeFragment extends BaseFragment<HomePresenterImp> implements HomeContract.View{
    @Bind(R.id.btn_home)
    Button btnHome;
    SVProgressHUD svProgressHUD;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onInitView(Bundle bundle) {
      svProgressHUD=new SVProgressHUD(getActivity());

    }
    @Override
    protected void onEvent() {

    }
    @Override
    protected Class getContractClazz() {
        return HomeContract.class;
    }

    @OnClick(R.id.btn_home)
    public void home()
    {
         mPresenter.message("这是首页消息");

    }
    @Override
    public void showSuccessWithStatus(String msg) {
        svProgressHUD.showSuccessWithStatus(msg);
    }

    @Override
    public void showErrorWithStatus(String msg) {

    }

    @Override
    public void showsInfoWithStatus(String msg) {

    }

    @Override
    public void showWithProgress(String msg) {

    }

    @Override
    public void dismiss() {

    }
}
