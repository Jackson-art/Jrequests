package hu.jspider.jrequests.method;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jrequests.Jresponse;

/**
 * ����ʽ�ӿ�
 *
 * @author Jackson-art
 */
public interface RequestMethod {

    /**
     * ��������������
     *
     * @param sUrl ����URL: String
     * @return Jresponse ����
     */
     Jresponse sendRequest(String sUrl);

    /**
     * ������ͷ������
     *
     * @param sUrl    ����url
     * @param headers ����ͷ
     * @return Jresponse����
     */
     Jresponse sendRequest(String sUrl, JSONObject headers);
}
