package com.goyin.mvp.base;
/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：
 *         1.获取绑定View实例传递到子类中进行调用!
 *
 *         2.注销View实例
 *
 *  备注消息：
 *  修改时间：2016/11/8 下午5:07
 **/
public class BasePresenter<T extends  BaseView> implements Presenter<T> {

    protected T mView;

//    获取绑定View实例
    @Override
    public void attachView(T view) {
          this.mView=view;
    }
//    注销View实例
    @Override
    public void detachView() {
         this.mView=null;
    }

    public T getView() {
        return mView;
    }

    public boolean isViewBind()
    {
        return mView!=null;
    }

}
