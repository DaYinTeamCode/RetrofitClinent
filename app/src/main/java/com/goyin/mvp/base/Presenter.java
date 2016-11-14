package com.goyin.mvp.base;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：
 *  备注消息：
 *  修改时间：2016/11/8 下午5:03
 **/
public interface Presenter<View> {
//    绑定View控件
    void attachView(View view);
//    注销View控件
    void detachView();

}
