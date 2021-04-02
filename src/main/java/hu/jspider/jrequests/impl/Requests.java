package hu.jspider.jrequests.impl;

import com.alibaba.fastjson.JSONObject;
import com.sun.istack.internal.NotNull;
import hu.jspider.jrequests.service.RequestsService;

/**
 * ʵ��RequestsImpl�ӿ�
 *
 * @author Hu.Sir
 */
public class Requests implements RequestsImpl {
    /**
     * ��ҳԴ��ı����ʽ : Ĭ��Ϊ UTF-8
     */
    public static String encode;

    public Requests() {
        Requests.encode = "UTF-8";
    }


    /**
     * Jrequests ���캯��
     *
     * @param encode ָ����ҳԴ��ı����ʽ
     */
    public Requests(String encode) {
        Requests.encode = encode;
    }

    /**
     * ����������GET����
     *
     * @param sUrl ����URL: String
     * @return Jresponse ����
     */
    @Override
    public Jresponse get(@NotNull String sUrl) {
        return new RequestsService().sendRequestByGet(sUrl);
    }

    /**
     * ��һ��������GET����
     *
     * @param sUrl       ����URL: String
     * @param jsonObject ���������JSONObject
     * @return Jresponse ����
     */
    @Override
    public Jresponse get(@NotNull String sUrl, JSONObject jsonObject) {
        return new RequestsService().sendRequestByGet(sUrl, jsonObject);
    }

    /**
     * ������������GET����
     *
     * @param sUrl        ����URL: String
     * @param jsonObject1 ���������JSONObject
     * @param jsonObject2 ���������JSONObject
     * @return Jresponse ����
     */
    @Override
    public Jresponse get(@NotNull String sUrl, JSONObject jsonObject1, JSONObject jsonObject2) {
        return new RequestsService().sendRequestByGet(sUrl, jsonObject1, jsonObject2);
    }

    /**
     * �����ͬʱ����
     *
     * @param objects ���в���
     * @return Jresponse ����
     */
    @Override
    public Jresponse get(@NotNull Object... objects) {
        return null;
    }


    /*===========================================    �� �� ��    ===========================================*/


    /**
     * ��������POST����
     *
     * @param sUrl ����URL: String
     * @return Jresponse ����
     */
    @Override
    public Jresponse post(@NotNull String sUrl) {
        return new RequestsService().sendRequestByPost(sUrl);
    }

    /**
     * ��һ��������POST����
     *
     * @param sUrl       ����URL: String
     * @param jsonObject �������: JSONObject
     * @return Jresponse ����
     */
    @Override
    public Jresponse post(@NotNull String sUrl, JSONObject jsonObject) {
        return new RequestsService().sendRequestByPost(sUrl, jsonObject);
    }

    /**
     * ������������POST����
     *
     * @param sUrl        ����URL: String
     * @param jsonObject1 �������: JSONObject
     * @param jsonObject2 �������: JSONObject
     * @return Jresponse ����
     */
    @Override
    public Jresponse post(@NotNull String sUrl, JSONObject jsonObject1, JSONObject jsonObject2) {
        return new RequestsService().sendRequestByPost(sUrl, jsonObject1, jsonObject2);
    }

    /**
     * �������POST����
     *
     * @param objects ���в���
     * @return Jresponse ����
     */
    @Override
    public Jresponse post(@NotNull Object... objects) {
        return null;
    }
}
