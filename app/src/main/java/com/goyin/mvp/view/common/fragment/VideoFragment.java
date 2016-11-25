package com.goyin.mvp.view.common.fragment;

import android.os.Bundle;
import android.widget.Button;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.gaoyin.mvp.R;
import com.goyin.mvp.base.BaseFragment;
import com.goyin.mvp.presenter.home.impl.HomePresenterImp;
import com.goyin.mvp.presenter.home.interfaces.HomeContract;

import butterknife.BindView;
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
public class VideoFragment extends BaseFragment{
    @BindView(R.id.btn_home)
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
        return null;
    }

    @OnClick(R.id.btn_home)
    public void home()
    {


    }
}
