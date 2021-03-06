package com.perry.http.request;


import com.perry.http.manager.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * 软著专用许可合同登记公告检索
 */
public class RzaSearchRequest extends Request {


    private String client_id;
    private String access_token;
    private String scope;
    private String express;
    private String page;
    private String sort_column;
    private String page_row;

    /**
     *
     * @param client_id
     * @param access_token
     * @param scope 默认值为：read_cn即可
     * @param express 搜索关键字
     * @param page
     * @param sort_column 排序字段
     * @param page_row
     */
    public RzaSearchRequest(String client_id, String access_token, String scope, String express, String page, String sort_column, String page_row) {
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
        map.put("page", page);
        map.put("sort_column", sort_column);
        map.put("page_row", page_row);
        return map;
    }

}
