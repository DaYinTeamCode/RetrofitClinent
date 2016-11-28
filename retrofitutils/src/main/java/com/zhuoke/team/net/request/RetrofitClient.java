package com.zhuoke.team.net.request;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：
 *  备注消息：
 *  修改时间：2016/11/22 下午11:27
 **/
public class RetrofitClient {

    private static OkHttpClient mOkHttpClient;
//    初始化BaseUrl
    private  static String baseUrl;

    private  static Retrofit retrofit;
    private  static GsonConverterFactory gsonConverterFactory;
    /**
     *   RetrofitClient 构造 函数
     *       获取OKhttpClient 实例
     * @param mOkHttpClient
     */
    public RetrofitClient(String baseUrl,OkHttpClient mOkHttpClient)
    {
        this.baseUrl=baseUrl;
        this.mOkHttpClient=mOkHttpClient;
        this.gsonConverterFactory = GsonConverterFactory.create(new Gson());
    }

    private  BaseServiceApi serviceApi;

    /**
     *  修改BaseUrl地址
     * @param baseUrl
     */
    public RetrofitClient setBaseUrl(String baseUrl)
    {
        this.baseUrl=baseUrl;
        return this;
    }

    /**
     *  获得对应的ApiServcie对象
     * @param service
     * @param <T>
     * @return
     */
    public  <T> T  builder(Class<T> service)
    {
        if(baseUrl==null)
        {
            throw new RuntimeException("baseUrl is null!");
        }
        if (service == null) {
            throw new RuntimeException("api Service is null!");
        }
        retrofit=new Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(service);

    }
//    /**
//     *   创建 BaseServiceApi
//     * @return
//     */
//    public Builder BaseApi()
//    {
//        serviceApi=create(BaseServiceApi.class);
//        return  this;
//
//    }
//    public <T> T create(final Class<T> service) {
//        if (service == null) {
//            throw new RuntimeException("Api service is null!");
//        }
//        else if(retrofit==null)
//        {
//            throw new RuntimeException("Retrofit Object is null!");
//        }
//        return retrofit.create(service);
//    }
//
//    public Subscription get(String url, Map<String,String> paramters, Subscriber subscriber)
//    {
//        return serviceApi.get(url,paramters)
//                .compose(schedulersTransformer)
//                .subscribe(subscriber);
//    }
//
//    final Observable.Transformer schedulersTransformer = new  Observable.Transformer() {
//        @Override public Object call(Object observable) {
//            return ((Observable)  observable).subscribeOn(Schedulers.io())
//                    .unsubscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread());
//        }
//    };


}
