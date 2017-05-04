package com.perry.http.request;


import com.perry.http.manager.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * 3.2.7. 查询个人信息
 */
public class UserInfoRequest extends Request {

    private static final String TAG = "TrainStationQueryRequest";

    private String user_name;
    private String version;
    private String token;

    public UserInfoRequest(String user_name,String version,String token) {
        this.version = version;
        this.user_name = user_name;
        this.token = token;
    }

//    @Override
//    public String url() {
//        String className = this.getClass().getSimpleName();
//        int size = ConfigXmlParser.getPluginEntries().size();
//        for(int i=0;i<size;i++){
//            HttpUrlEntry httpUrlEntry = ConfigXmlParser.getPluginEntries().get(i);
//            Log.e(TAG,"httpUrlEntry:"+httpUrlEntry.toString());
//            if(className.equals(httpUrlEntry.urlName)){
//                //
//                return httpUrlEntry.urlAddress;
//            }
//        }
//        return null;
////        return IssRequest.buildUrl(IssRequest.url_detailDate);
//    }

    @Override
    public int method() {
        return RequestMethod.POST;
    }

//    {"from_station":"VNP","to_station":"AOH","queryDate":"2016-11-30"}

    @Override
    public Map<String, String> getParameter() {
        Map<String, String> map = new HashMap<String,String>();
        map.put("version", version);
        map.put("user_name", user_name);
        map.put("token", token);
        return map;
    }

}
