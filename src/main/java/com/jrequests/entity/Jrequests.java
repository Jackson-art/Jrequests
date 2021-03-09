package com.jrequests.entity;

import com.alibaba.fastjson.JSONObject;
import com.jrequests.service.RequestsService;

/**
 * Jrequests实体类
 *
 * @author Hu.Sir
 */
public class Jrequests {
    /**
     * 不带参数的GET请求
     *
     * @param sUrl 请求URL: String
     * @return Jresponse 对象
     */
    public static Jresponse get(String sUrl) {
        return new RequestsService().getJresponseByGet(sUrl);
    }

    /**
     * 带参数的GET请求
     *
     * @param sUrl   请求URL: String
     * @param params 请求参数：JSONObject
     * @return Jresponse 对象
     */
    public static Jresponse get(String sUrl, JSONObject params) {
        return new RequestsService().getJresponseByGet(sUrl, params);
    }

    /**
     * 不带请求体POST请求
     *
     * @param sUrl 请求URL String
     * @return Jresponse 对象
     */
    public static Jresponse post(String sUrl) {
        return new RequestsService().getJresponseByPost(sUrl);
    }

    /**
     * 带请求体的POST请求
     *
     * @param sUrl 请求URL: String
     * @param json 请求体
     * @return Jresponse 对象
     */
    public static Jresponse post(String sUrl, JSONObject json) {
        return new RequestsService().getJresponseByPost(sUrl, json);
    }

}
