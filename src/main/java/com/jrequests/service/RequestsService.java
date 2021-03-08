package com.jrequests.service;

import com.alibaba.fastjson.JSONObject;
import com.jrequests.entity.Jresponse;
import com.jrequests.service.method.GetMethod;
import com.jrequests.service.method.PostMethod;

/**
 * ว๋ว๓อ๘าณ
 *
 * @author Hu.Sir
 */
public class RequestsService {

    public Jresponse getJresponseByGet(String sUrl) {
        return new GetMethod().getJresponseObject(sUrl);
    }

    public Jresponse getJresponseByPost(String sUrl, JSONObject json) {
        return new PostMethod().getJresponseObject(sUrl, json);
    }

    public Jresponse getJresponseByPost(String sUrl) {
        return new PostMethod().getJresponseObject(sUrl, null);
    }
}