package com.jrequests.service;

import com.alibaba.fastjson.JSONObject;
import com.jrequests.entity.Jresponse;
import com.jrequests.service.method.GetMethod;
import com.jrequests.service.method.PostMethod;

/**
 * ������ҳ
 *
 * @author Hu.Sir
 */
public class RequestsService {

    /**
     * ����������GET����
     *
     * @param sUrl ����URL: String
     * @return Jresponse ����
     */
    public Jresponse getJresponseByGet(String sUrl) {
        return new GetMethod().getJresponseObject(sUrl, null);
    }
    /**
     * ��������GET����
     *
     * @param sUrl   ����URL: String
     * @param params ���������JSONObject
     * @return Jresponse ����
     */
    public Jresponse getJresponseByGet(String sUrl, JSONObject params) {
        return new GetMethod().getJresponseObject(sUrl, params);
    }
    /**
     * ����������POST����
     *
     * @param sUrl ����URL String
     * @return Jresponse ����
     */
    public Jresponse getJresponseByPost(String sUrl) {
        return new PostMethod().getJresponseObject(sUrl, null);
    }
    /**
     * ���������POST����
     *
     * @param sUrl ����URL: String
     * @param json ������
     * @return Jresponse ����
     */
    public Jresponse getJresponseByPost(String sUrl, JSONObject json) {
        return new PostMethod().getJresponseObject(sUrl, json);
    }

}