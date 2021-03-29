package hu.jspider.jrequests.service;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jrequests.entity.Jresponse;
import hu.jspider.jrequests.method.GET;
import hu.jspider.jrequests.method.POST;

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
        return new GET().getJresponseWithParams(sUrl, null);
    }

    /**
     * ��������GET����
     *
     * @param sUrl   ����URL: String
     * @param params ���������JSONObject
     * @return Jresponse ����
     */
    public Jresponse getJresponseByGetWithParams(String sUrl, JSONObject params) {
        return new GET().getJresponseWithParams(sUrl, params);
    }

    /**
     * ������ͷ��GET����
     *
     * @param sUrl    ����URL: String
     * @param headers ���������JSONObject
     * @return Jresponse ����
     */
    public Jresponse getJresponseByGetWithHeaders(String sUrl, JSONObject headers) {
        return new GET().getJresponseWithHeaders(sUrl, headers);
    }

    /**
     * ����������POST����
     *
     * @param sUrl ����URL String
     * @return Jresponse ����
     */
    public Jresponse getJresponseByPost(String sUrl) {
        return new POST().getJresponseObject(sUrl, null);
    }

    /**
     * ���������POST����
     *
     * @param sUrl ����URL: String
     * @param json ������
     * @return Jresponse ����
     */
    public Jresponse getJresponseByPost(String sUrl, String json) {
        return new POST().getJresponseObject(sUrl, json);
    }

    /**
     * �������������ͷ��POST����
     *
     * @param sUrl    ����URL: String
     * @param headers ����ͷ
     * @param data    ������
     * @return Jresponse ����
     */
    public Jresponse getJresponseByPost(String sUrl, JSONObject headers, String data) {
        return new POST().getJresponseObject(sUrl, headers, data);
    }
}