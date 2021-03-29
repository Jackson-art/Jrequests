package hu.jspider.jrequests.entity;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jrequests.service.RequestsService;
import hu.jspider.jrequests.util.StringUtil;

/**
 * Jrequestsʵ����
 *
 * @author Hu.Sir
 */
public class Jrequests {
    public static String encode;

    public Jrequests() {
        encode = "UTF-8";
    }

    public Jrequests(String encode) {
        Jrequests.encode = encode;
    }

    /**
     * ����������GET����
     *
     * @param sUrl ����URL: String
     * @return Jresponse ����
     */
    public Jresponse get(String sUrl) {
        return new RequestsService().getJresponseByGet(sUrl);
    }

    /**
     * ��������GET����
     *
     * @param sUrl       ����URL: String
     * @param jsonObject ���������JSONObject
     * @return Jresponse ����
     */
    public Jresponse get(String sUrl, JSONObject jsonObject) {
        String flag = "user-agent";
        if (StringUtil.isExistIgnoreCase(jsonObject.keySet(), flag)) {
            return new RequestsService().getJresponseByGetWithHeaders(sUrl, jsonObject);
        } else {
            return new RequestsService().getJresponseByGetWithParams(sUrl, jsonObject);
        }
    }

    /**
     * ����������POST����
     *
     * @param sUrl ����URL String
     * @return Jresponse ����
     */
    public Jresponse post(String sUrl) {
        return new RequestsService().getJresponseByPost(sUrl);
    }

    /**
     * ���������POST����
     *
     * @param sUrl ����URL: String
     * @param json ������
     * @return Jresponse ����
     */
    public Jresponse post(String sUrl, String json) {
        return new RequestsService().getJresponseByPost(sUrl, json);
    }

    public Jresponse post(String sUrl, JSONObject headers, String data) {
        return new RequestsService().getJresponseByPost(sUrl, headers, data);
    }
}
