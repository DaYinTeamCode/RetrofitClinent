package com.zhuoke.team.net.callback;

import android.util.Log;

import com.zhuoke.team.net.exception.ExceptionHandle;
import com.zhuoke.team.net.exception.ResponeThrowable;
import com.zhuoke.team.net.transformer.ErrorTransformer;

import rx.Subscriber;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：
 *  备注消息：
 *  修改时间：2016/11/24 上午10:56
 **/
public  abstract class RxSubscriber<T> extends ErrorSubscriber<T> {

//    /**
//     *  请求网络错误
//     * @param e
//     */
//    @Override
//    public void onError(Throwable e) {
//        // todo error somthing
//
//        if(e instanceof ResponeThrowable){
//            onError((ResponeThrowable)e);
//        }
//        else
//        {
////                 未知错误
//             onError(new ResponeThrowable(e,1000));
//        }
//    }


    @Override
    protected void onError(ResponeThrowable ex) {
        Log.e("aaaaa", "onError: " + ex.message + "code: " + ex.code);
    }

    /**
     *  开始请求网络
     */
    @Override
    public void onStart() {
        super.onStart();
        // todo some common as show loadding  and check netWork is NetworkAvailable
    }
    /**
     *   请求网络完成
     */
    @Override
    public void onCompleted() {
    }
    /**
     *  获取网络数据
     * @param t
     */
    @Override
    public void onNext(T t) {

          onSuccess(t);
    }
    public abstract  void onSuccess(T t);

}