#Retrofit+Rxjava网络封装
[DEMO下载地址](https://github.com/GaoYin2016/mvpDemo)

##框架使用说明

###一.项目中使用到的三方库
>  
   * com.squareup.retrofit2:retrofit:2.1.0
   * com.squareup.retrofit2:adapter-rxjava:2.1.0
   * com.squareup.retrofit2:converter-gson:2.1.0
   * com.squareup.okhttp3:okhttp:3.2.0
   * com.squareup.okhttp3:logging-interceptor:3.3.1
   * io.reactivex:rxjava:1.1.8  
   * io.reactivex:rxandroid:1.2.1
   * com.trello:rxlifecycle:0.6.1 
   * com.trello:rxlifecycle-components:0.6.1
   
###二.使用步骤 
[^emphasize]:
1.在AndroidManifest.xml配置访问网络权限等操作 

```
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
```

[^emphasize]:
2.在Application类对NetWorkConfiguration进行配置，该类主要对网络参数进行基本配置，如：

```
NetWorkConfiguration configuration=new NetWorkConfiguration(this)
                                        .baseUrl(NetWorkApi.baseUrl)
                                        .isCache(true)
                                        .isDiskCache(true)
                                        .isMemoryCache(false);
HttpUtils.setConFiguration(configuration);
```
### NetWorkConfiguration API
>
   * baseUrl（String）           		设置网络BaseUrl地址 
   * isCache(boolean)          		设置是否开启缓存功能，true为开启，false为关闭 
   * isDiskCache（boolean）   			设置是否进行磁盘缓存 
   * isMemoryCache（boolean） 			设置是否进行内存缓存
   * memoryCacheTime（int）     		设置内存缓存时间
   * diskCacheTime（int） 				设置本地缓存时间
   * diskCaChe（File,int）				设置本地缓存路径以及最大缓存大小
   * connectTimeOut（int）				设置网络超时时间
   * connectionPool（int,int,TimeUnit）设置网络线程池
   * certificates（InputStream...）    设置Https客户端证书访问
 
#####注：如果不进行配置，进行默认设置网络参数！  
[^emphasize]:
3.针对进行网络访问，通过链式编程进行参数设置以及获取服务器返回数据!
  如： 
  
  ```
         HttpUtils.getInstance(mView.getContext())
                .setLoadDiskCache(true)
                .setLoadMemoryCache(false)
                .getRetofitClinet()
                .builder(DouYuApi.class)
                .getColumnDetail(ParamsMapUtils.getColumnDatail("game"))
//               进行预处理
                .compose(new DefaultTransformer<List<ColumnDetail>>())
//               绑定当前activity或者fragment 与Observable 的生命周期
                .compose(mView.<List<ColumnDetail>>bindToLifecycle())
                .subscribe(new RxSubscriber<List<ColumnDetail>>() {
                   @Override
                   public void onSuccess(List<ColumnDetail> columnDetails) {
                        L.e("数据为:" + columnDetails.toString());
                   }
                   @Override
                   public void onError(ResponeThrowable e) {
                        L.DEBUG = true;
                        L.e("错误信息:" + e.message);
                   }
               });
  ```
###HttpUtils API

   * getInstance(Context)      获取HttpUtils实例
   * setConFiguration（NetWorkConfiguration） 设置网络配置器
   * setLoadDiskCache(boolean)       设置断网时是否加载本地缓存数据
   * setLoadMemoryCache（boolean）   	设置有网络时是否优先加载内存缓存
   * getRetofitClinet（） 			   创建RetrofitClient对象
   * setCertificates（InputStream...）设置Https客户端证书访问
   * setDBugLog（boolean）           设置是否打印网络日志
   * addCookie（） 						设置cookie
   
###RetrofitClient API

>
   * setBaseUrl（String） 设置BaseUrl地址
   * builder(Class<?>)   创建Service对象
   
###RxJava  API
  compose：是唯一一个能够从数据流中得到原始Observable<T>的操作符，所以，那些需要对整个数据流产生作用的操作（比如，subscribeOn()和observeOn()）需要使用compose()来实现。
  
 ```
.compose(new DefaultTransformer<List<ColumnDetail>>())
 ```
作用：对服务器返回的数据进行预处理
     1.数据获取正常-->call方法中根据与服务器约定判断数据是否合法 ！不合法，抛出自定义异常进行处理！
     2.数据获取失败-->onErrorResumeNext方法，抛出自定义异常进行处理！
     
```
.compose(mView.<List<ColumnDetail>>bindToLifecycle())
```
作用：Activity或者Framgnet的生命周期与Observable进行绑定

###RxSubscriber 回调类 
  ```
       @Override
       public void onSuccess(List<ColumnDetail> columnDetails) {
            L.e("数据为:" + columnDetails.toString());
       }
  ```
如果网络数据访问正常回调onSuccess方法，获取到对应的Java Bean

```
       @Override
       public void onError(ResponeThrowable e) {
            L.DEBUG = true;
            L.e("错误信息:" + e.message);
       }
```
如果网络数据访问失败回调onError方法，获取到自定义异常ResponeThrowable信息，可以通过e获取到code和message等！






