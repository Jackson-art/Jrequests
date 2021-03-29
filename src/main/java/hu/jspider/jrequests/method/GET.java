package hu.jspider.jrequests.method;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jrequests.entity.Jresponse;
import hu.jspider.jrequests.entity.model.JresponseModel;
import hu.jspider.jrequests.util.JrequestsUtil;

import java.net.HttpURLConnection;

/**
 * GET ����
 *
 * @author Hu.Sir
 */
public class GET {
    /**
     * ��������GET����
     *
     * @param sUrl   ����url
     * @param params �������
     * @return Jresponse����
     */
    public Jresponse getJresponseWithParams(String sUrl, JSONObject params) {
        // ������ƴ�ӵ���������
        String realUrl;
        if (params != null) {
            realUrl = JrequestsUtil.getRealUrl(sUrl, params);
        } else {
            realUrl = sUrl;
        }

        // ��ȡһ������
        HttpURLConnection httpUrlConnection = Request.getConnection(realUrl);
        // ��ȡ���������
        Jresponse jresponse = JresponseModel.getJresponse(httpUrlConnection);
        httpUrlConnection.disconnect();
        return jresponse;
    }

    /**
     * ������ͷ��GET����
     *
     * @param sUrl    ����url
     * @param headers ����ͷ
     * @return Jresponse����
     */
    public Jresponse getJresponseWithHeaders(String sUrl, JSONObject headers) {
        // ��ȡһ������
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl);
        // ��������ͷ
        for (String k : headers.keySet()) {
            httpUrlConnection.setRequestProperty(k, headers.getString(k));
        }

        // ��ȡ���������
        Jresponse jresponse = JresponseModel.getJresponse(httpUrlConnection);
        httpUrlConnection.disconnect();
        return jresponse;
    }


}
