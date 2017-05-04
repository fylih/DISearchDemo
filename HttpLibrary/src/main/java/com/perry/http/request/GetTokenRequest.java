package com.perry.http.request;


import com.perry.http.manager.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * 3.2.7. 查询个人信息
 */
public class GetTokenRequest extends Request {


    private String client_id;
    private String redirect_uri;
    private String response_type;
    private String grant_type;

    public GetTokenRequest(String client_id, String redirect_uri, String response_type, String grant_type) {
        this.client_id = client_id;
        this.redirect_uri = redirect_uri;
        this.response_type = response_type;
        this.grant_type = grant_type;
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
        map.put("redirect_uri", redirect_uri);
        map.put("response_type", response_type);
        map.put("grant_type", grant_type);

        return map;
    }

}
