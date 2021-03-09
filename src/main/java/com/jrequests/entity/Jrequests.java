package com.jrequests.entity;

import com.alibaba.fastjson.JSONObject;
import com.jrequests.service.RequestsService;

/**
 * Jrequestsʵ����
 *
 * @author Hu.Sir
 */
public class Jrequests {
    /**
     * ����������GET����
     *
     * @param sUrl ����URL: String
     * @return Jresponse ����
     */
    public static Jresponse get(String sUrl) {
        return new RequestsService().getJresponseByGet(sUrl);
    }

    /**
     * ��������GET����
     *
     * @param sUrl   ����URL: String
     * @param params ���������JSONObject
     * @return Jresponse ����
     */
    public static Jresponse get(String sUrl, JSONObject params) {
        return new RequestsService().getJresponseByGet(sUrl, params);
    }

    /**
     * ����������POST����
     *
     * @param sUrl ����URL String
     * @return Jresponse ����
     */
    public static Jresponse post(String sUrl) {
        return new RequestsService().getJresponseByPost(sUrl);
    }

    /**
     * ���������POST����
     *
     * @param sUrl ����URL: String
     * @param json ������
     * @return Jresponse ����
     */
    public static Jresponse post(String sUrl, JSONObject json) {
        return new RequestsService().getJresponseByPost(sUrl, json);
    }

}
