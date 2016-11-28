package com.zhuoke.team.utils;

import com.zhuoke.team.net.exception.ExceptionHandle;
import com.zhuoke.team.net.exception.ServerException;
import com.zhuoke.team.net.response.HttpResponse;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：  针对RxJava  帮助类 RxUtils
 *  备注消息：
 *  修改时间：2016/11/23 下午4:52
 **/
public class RxUtils {
    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {


                return ((Observable) observable).subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     *  预处理异常
     *     处理Json解析
     *    针对 服务器端 对error 不为0 情况进行处理
     * @param clazz
     * @param <T>
     * @return
     */
//    public static <T extends HttpResponse>Observable.Transformer<String,T> trans(final Class<T> clazz)
//    {
//        return new Observable.Transformer<String, T>() {
//            @Override
//            public Observable<T> call(Observable<String> stringObservable) {
//                HttpResponse response=GsonUtils.fromJson(String.valueOf(stringObservable),HttpResponse.class);
//                  if(null==response||null==response.getData())
//                  {
//                       throw  new RuntimeException("response is  null or data is null");
//                  }
//                  if(response.getError()!=0&&response.getData() instanceof  String)
//                  {
//                      throw  new RuntimeException("response  errror ");
//                  }
//                return  GsonUtils.<T>fromJson(stringObservable.toString(),clazz);
//            }
//        };
//    }
    /**
     *   进行异常预处理
     * @param <T>
     * @return
     */
    public  static <T> Observable.Transformer<HttpResponse<T>, T> transformer() {
        return new Observable.Transformer() {
            @Override
            public Object call(Object observable) {
                L.DEBUG=true;
                L.e("bean数据:"+observable.toString());
                return ((Observable) observable).map(new HandleFuc<T>())
                        .onErrorResumeNext(new HttpResponseFunc<T>());
            }
        };
    }
    public  class transformer<T> implements Observable.Transformer<HttpResponse<T>,T>{

        @Override
        public Observable<T> call(Observable<HttpResponse<T>> httpResponseObservable) {
            return httpResponseObservable.map(new Func1<HttpResponse<T>, T>() {
                @Override
                public T call(HttpResponse<T> tHttpResponse) {
                    if(tHttpResponse.getError()!=0) {
                        throw new ServerException(tHttpResponse.getData().toString(), tHttpResponse.getError());
                    }
                    return tHttpResponse.getData();
                }
            }).onErrorResumeNext(new Func1<Throwable, Observable<? extends T>>() {
                @Override
                public Observable<? extends T> call(Throwable throwable) {
                    throwable.printStackTrace();
                    return Observable.error(ExceptionHandle.handleException(throwable));
                }
            });
        }
    }

    /**
     *
     *    拦截器
     *      对请求服务器出现错误信息进行拦截
     * @param <T>
     */
    private static class HttpResponseFunc<T> implements Func1<Throwable, Observable<T>> {
        @Override public Observable<T> call(Throwable t) {
            t.printStackTrace();
            return Observable.error(ExceptionHandle.handleException(t));
        }
    }

    /**
     *
     *  获取数据成功
     *       对服务器端给出Json数据进行校验
     * @param <T>
     */
    private static class HandleFuc<T> implements Func1<HttpResponse<T>, T> {
        @Override
        public T call(HttpResponse<T> response) {
            if (response.getError() != 0) {
                //如果服务器端有错误信息返回，那么抛出异常，让下面的方法去捕获异常做统一处理
                throw  new ServerException(String.valueOf(response.getData()),response.getError());
            }
            //服务器请求数据成功，返回里面的数据实体
            return response.getData();
        }
    }






}
