package hu.jspider.jrequests.impl;

import com.alibaba.fastjson.JSONObject;

import java.net.URL;

/**
 * ������ӿ�
 *
 * @author Hu.Sir
 */
public interface ResponseImpl {

    /**
     * ��ȡ�������ʵURL
     *
     * @return URL����
     */
    URL getUrl();

    /**
     * ��ȡ��Ӧ��JSON����
     *
     * @return ��Ӧ��: JSONObject
     */
    JSONObject getJson();

    /**
     * ��ȡ��ҳԴ��
     *
     * @return ��ҳԴ��: String
     */
    String getText();

    /**
     * ��ȡ����״̬��
     *
     * @return ����״̬��: Integer
     */
    Integer getStatusCode();


    /**
     * ��ȡ����ͷ
     *
     * @return ��ȡ����ͷ: JSONObject
     */
    JSONObject getRequestsHeaders();

    /**
     * ��ȡ����ͷ�ֶε�ֵ
     *
     * @param key ��Ӧͷ�еļ�: String
     * @return ��Ӧ��ֵ
     */
    String getRequestsHeader(String key);

    /**
     * ��ȡ��Ӧͷ
     *
     * @return ��Ӧͷ: JSONObject
     */
    JSONObject getResponseHeaders();

    /**
     * ��ȡ��Ӧͷ�ֶε�ֵ
     *
     * @param key ��Ӧͷ�еļ�: String
     * @return ��Ӧ��ֵ
     */
    String getResponseHeader(String key);

}
