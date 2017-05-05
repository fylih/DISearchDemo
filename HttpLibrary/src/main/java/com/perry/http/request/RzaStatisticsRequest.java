package com.perry.http.request;


import com.perry.http.manager.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * 软著专用许可分类查询
 */
public class RzaStatisticsRequest extends Request {


    private String client_id;
    private String access_token;
    private String scope;
    private String express;
    private String categoryColumn;

    public RzaStatisticsRequest(String client_id, String access_token, String scope, String express, String categoryColumn) {
        this.client_id = client_id;
        this.access_token = access_token;
        this.scope = scope;
        this.express = express;
        this.categoryColumn = categoryColumn;

    }


    @Override
    public int method() {
        return RequestMethod.POST;
    }

//    {"from_station":"VNP","to_station":"AOH","queryDate":"2016-11-30"}

    @Override
    public Map<String, String> getParameter() {
        Map<String, String> map = new HashMap<String,String>();
        map.put("client_id", client_id);
        map.put("access_token", access_token);
        map.put("scope", scope);
        map.put("express", express);
        map.put("categoryColumn",categoryColumn);
        return map;
    }

}
