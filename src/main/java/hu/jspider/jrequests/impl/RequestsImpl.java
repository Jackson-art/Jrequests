package hu.jspider.jrequests.impl;

import com.alibaba.fastjson.JSONObject;
import com.sun.istack.internal.NotNull;

/**
 * ����ӿ�
 *
 * @author Hu.Sir
 */
public interface RequestsImpl {

    /**
     * ����������GET����
     *
     * @param sUrl ����URL: String
     * @return Jresponse ����
     */
    Jresponse get(@NotNull String sUrl);

    /**
     * ��һ��������GET����
     *
     * @param sUrl       ����URL: String
     * @param jsonObject ���������JSONObject
     * @return Jresponse ����
     */
    Jresponse get(@NotNull String sUrl, JSONObject jsonObject);

    /**
     * ������������GET����
     *
     * @param sUrl        ����URL: String
     * @param jsonObject1 ���������JSONObject
     * @param jsonObject2 ���������JSONObject
     * @return Jresponse ����
     */
    Jresponse get(@NotNull String sUrl, JSONObject jsonObject1, JSONObject jsonObject2);

    /**
     * �����ͬʱ����
     *
     * @param objects ���в���
     * @return Jresponse ����
     */
    Jresponse get(@NotNull Object... objects);

    /**
     * ��������POST����
     *
     * @param sUrl ����URL: String
     * @return Jresponse ����
     */
    Jresponse post(@NotNull String sUrl);

    /**
     * ��һ��������POST����
     *
     * @param sUrl       ����URL: String
     * @param jsonObject �������: JSONObject
     * @return Jresponse ����
     */
    Jresponse post(@NotNull String sUrl, JSONObject jsonObject);

    /**
     * ������������POST����
     *
     * @param sUrl        ����URL: String
     * @param jsonObject1 �������: JSONObject
     * @param jsonObject2 �������: JSONObject
     * @return Jresponse ����
     */
    Jresponse post(@NotNull String sUrl, JSONObject jsonObject1, JSONObject jsonObject2);

    /**
     * �������POST����
     *
     * @param objects ���в���
     * @return Jresponse ����
     */
    Jresponse post(@NotNull Object... objects);

}
