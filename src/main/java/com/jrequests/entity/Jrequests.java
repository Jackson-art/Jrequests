package com.jrequests.entity;

import com.alibaba.fastjson.JSONObject;
import com.jrequests.service.RequestsService;

/**
 * Jrequests µÃÂ¿‡
 *
 * @author Hu.Sir
 */
public class Jrequests {
    public static Jresponse get(String sUrl) {
        return new RequestsService().getJresponseByGet(sUrl);
    }

    public static Jresponse post(String sUrl, JSONObject json) {
        return new RequestsService().getJresponseByPost(sUrl, json);
    }

    public static Jresponse post(String sUrl) {
        return new RequestsService().getJresponseByPost(sUrl);
    }
}
