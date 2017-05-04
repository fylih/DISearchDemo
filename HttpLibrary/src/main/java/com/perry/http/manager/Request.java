package com.perry.http.manager;


import android.util.Log;

import com.perry.http.Listener.AppCallback;
import com.perry.http.parser.ConfigXmlParser;
import com.perry.http.parser.HttpUrlEntry;

import java.io.File;
import java.util.Map;

/**
 * Created by isoftstone on 16/11/29.
 * 继承此类写出具体的请求类；思想是每一个请求编写一个请求类；
 */
public abstract class Request {

    private static final String TAG = "Request";
    protected Response response;

//    public abstract String url();

    public abstract int method();

    /**
     * 设置请求body里面的参数
     * @return
     */
    public abstract Map<String, String> getParameter();

    /**
     * 直接遍历获取配置文件中的请求连接地址是否和子类名称有匹配的；
     * 即是否在配置文件中注册请求地址；
     * @return
     */
    public  String url(){
        String className = this.getClass().getSimpleName();
        Log.e(TAG,"网络请求的名称:"+className);
        int size = ConfigXmlParser.getPluginEntries().size();
        for(int i=0;i<size;i++){
            HttpUrlEntry httpUrlEntry = ConfigXmlParser.getPluginEntries().get(i);
            Log.e(TAG,"注册表遍历是否注册:"+httpUrlEntry.toString());
            if(className.equals(httpUrlEntry.urlName)){
                //
                Log.e(TAG,"遍历成功注册:"+httpUrlEntry.urlAddress);
                return httpUrlEntry.urlAddress;
            }
        }
        Log.e(TAG,"遍历失败，注册表httpurl.xml中未找到:"+className+" 的注册信息");
        return null;
    }
    public Map<String, File> getFileParameter() {
        return null;
    }

    public  Response getResponse() {
        return response;
    }

    public Request withResponse(Response response) {
        this.response = response;
        return this;
    }

    public <T> Request withResponse(Class<T> cls, AppCallback<T> callback) {
        this.response = new Response(cls, callback);
        return  this;
    }

    public static class Response<T> {

        public Response(Class<T> cls, AppCallback<T> callback) {
            this.cls = cls;
            this.callback = callback;
        }

        private AppCallback<T> callback;
        private Class<T> cls;

        public AppCallback<T> getCallback() {
            return callback;
        }

        public Class<T> getCls() {
            return cls;
        }
    }

    public interface RequestMethod {
        int POST = 1; //com.android.volley.Request.Method.POST;
        int GET = 0; //com.android.volley.Request.Method.GET;
    }

}
