package com.perry.http.request;


import com.perry.http.manager.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * 软著登记撤销检索
 */
public class RzpSearchRequest extends Request {


    private String client_id;
    private String access_token;
    private String scope;
    private String express;
    private String page;
    private String sort_column;
    private String page_row;

    public RzpSearchRequest(String client_id, String access_token, String scope, String express, String page, String sort_column, String page_row) {
        this.client_id = client_id;
        this.access_token = access_token;
        this.scope = scope;
        this.express = express;
        this.page = page;
        this.sort_column = sort_column;
        this.page_row = page_row;
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
        map.put("page", page);
        map.put("sort_column", sort_column);
        map.put("page_row", page_row);
        return map;
    }

}
