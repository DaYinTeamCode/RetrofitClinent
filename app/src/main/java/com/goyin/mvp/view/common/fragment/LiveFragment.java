package com.goyin.mvp.view.common.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.gaoyin.mvp.R;
import com.goyin.mvp.base.BaseFragment;
import com.goyin.mvp.presenter.live.impl.LivePresenterImp;
import com.goyin.mvp.presenter.live.interfaces.LiveContract;

import butterknife.BindView;
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
public class LiveFragment extends BaseFragment<LivePresenterImp> implements LiveContract.View {

    SVProgressHUD svProgressHUD;
    @BindView(R.id.btn_live)
    Button btnLive;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live;
    }

    @Override
    protected void onInitView(Bundle bundle) {
        svProgressHUD = new SVProgressHUD(getActivity());

    }

    @Override
    protected void onEvent() {

    }

    @Override
    protected Class getContractClazz() {
        return LiveContract.class;
    }

    @OnClick(R.id.btn_live)
    public void home() {
        mPresenter.allLiveList();
    }

    @Override
    public void showSuccessWithStatus(String msg) {

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
