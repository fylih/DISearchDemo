package com.perry.http.request;


import com.perry.http.manager.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * 软著登记撤销分类统计查询
 */
public class RzcStatisticsRequest extends Request {


    private String client_id;
    private String access_token;
    private String scope;
    private String express;
    private String categoryColumn;

    public RzcStatisticsRequest(String client_id, String access_token, String scope, String express, String categoryColumn) {
        this.client_id = client_id;
        this.access_token = access_token;
        this.scope = scope;
        this.express = express;
        this.categoryColumn = categoryColumn;

    }


    @Override
    public int method() {
        return RequestMethod.GET;
//        return RequestMethod.POST;
    }

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
