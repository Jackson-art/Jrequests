package com.jrequests.service;

import com.alibaba.fastjson.JSONObject;
import com.jrequests.entity.Jresponse;
import com.jrequests.service.method.GetMethod;
import com.jrequests.service.method.PostMethod;

/**
 * 请求网页
 *
 * @author Hu.Sir
 */
public class RequestsService {

    /**
     * 不带参数的GET请求
     *
     * @param sUrl 请求URL: String
     * @return Jresponse 对象
     */
    public Jresponse getJresponseByGet(String sUrl) {
        return new GetMethod().getJresponseObject(sUrl, null);
    }
    /**
     * 带参数的GET请求
     *
     * @param sUrl   请求URL: String
     * @param params 请求参数：JSONObject
     * @return Jresponse 对象
     */
    public Jresponse getJresponseByGet(String sUrl, JSONObject params) {
        return new GetMethod().getJresponseObject(sUrl, params);
    }
    /**
     * 不带请求体POST请求
     *
     * @param sUrl 请求URL String
     * @return Jresponse 对象
     */
    public Jresponse getJresponseByPost(String sUrl) {
        return new PostMethod().getJresponseObject(sUrl, null);
    }
    /**
     * 带请求体的POST请求
     *
     * @param sUrl 请求URL: String
     * @param json 请求体
     * @return Jresponse 对象
     */
    public Jresponse getJresponseByPost(String sUrl, JSONObject json) {
        return new PostMethod().getJresponseObject(sUrl, json);
    }

}