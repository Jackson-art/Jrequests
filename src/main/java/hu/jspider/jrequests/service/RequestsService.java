package hu.jspider.jrequests.service;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jrequests.Jresponse;
import hu.jspider.jrequests.method.Get;
import hu.jspider.jrequests.method.Post;
import hu.jspider.jrequests.util.JrequestsUtil;
import hu.jspider.jrequests.util.StringUtil;

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
    public Jresponse sendRequestByGet(String sUrl) {
        return new Get().sendRequest(sUrl);
    }

    /**
     * ��������GET����
     *
     * @param sUrl       ����URL: String
     * @param jsonObject ���������JSONObject
     * @return Jresponse ����
     */
    public Jresponse sendRequestByGet(String sUrl, JSONObject jsonObject) {
        String flag = "user-agent";
        // �жϲ����Ƿ�Ϊ����ͷ
        if (StringUtil.isExistIgnoreCase(jsonObject.keySet(), flag)) {
            return new Get().sendRequest(sUrl, jsonObject);
        } else {
            return new Get().sendRequest(JrequestsUtil.getRealUrl(sUrl, jsonObject));
        }
    }

    /**
     * ������������GET����
     *
     * @param sUrl        ����URL: String
     * @param jsonObject1 ���������JSONObject
     * @param jsonObject2 ���������JSONObject
     * @return Jresponse ����
     */
    public Jresponse sendRequestByGet(String sUrl, JSONObject jsonObject1, JSONObject jsonObject2) {
        String flag = "user-agent";
        // �жϲ����Ƿ�Ϊ����ͷ
        if (StringUtil.isExistIgnoreCase(jsonObject1.keySet(), flag)) {
            // ��jsonObject1Ϊ����ͷ
            return new Get().sendRequest(JrequestsUtil.getRealUrl(sUrl, jsonObject1), jsonObject2);
        } else {
            // ��jsonObject2Ϊ����ͷ
            return new Get().sendRequest(JrequestsUtil.getRealUrl(sUrl, jsonObject2), jsonObject1);
        }
    }


    /*===========================================    �� �� ��    ===========================================*/


    /**
     * ����������POST����
     *
     * @param sUrl ����URL: String
     * @return Jresponse ����
     */
    public Jresponse sendRequestByPost(String sUrl) {
        return new Post().sendRequest(sUrl);
    }

    /**
     * ��һ��������POST����
     *
     * @param sUrl       ����URL: String
     * @param jsonObject �������: JSONObject
     * @return Jresponse ����
     */
    public Jresponse sendRequestByPost(String sUrl, JSONObject jsonObject) {
        return new Post().sendRequest(sUrl, jsonObject);
    }

    /**
     * ������������GET����
     *
     * @param sUrl        ����URL: String
     * @param jsonObject1 ���������JSONObject
     * @param jsonObject2 ���������JSONObject
     * @return Jresponse ����
     */
    public Jresponse sendRequestByPost(String sUrl, JSONObject jsonObject1, JSONObject jsonObject2) {
        return new Post().sendRequest(sUrl, jsonObject1, jsonObject2);
    }

}