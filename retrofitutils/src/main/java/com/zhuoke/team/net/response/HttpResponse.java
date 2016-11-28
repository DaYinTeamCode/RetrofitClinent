package com.zhuoke.team.net.response;

import com.google.gson.annotations.SerializedName;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述： 约定服务器公共的json数据
 *  备注消息：
 *  修改时间：2016/11/23 下午5:52
 **/
public class HttpResponse<T> {
    /**
     *  状态码
    */
    private int error;
    /**
     *   java Bean
     */
    @SerializedName(value = "data", alternate = {"subjects"})
    private  T data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "HttpResponse{" +
                "error=" + error +
                ", data=" + data +
                '}';
    }
}
