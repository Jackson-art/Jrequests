package hu.jspider.jrequests.method;

import com.alibaba.fastjson.JSONObject;
import com.sun.istack.internal.NotNull;
import hu.jspider.jrequests.Jresponse;
import hu.jspider.jrequests.entity.JresponseModel;

import java.net.HttpURLConnection;

/**
 * Get ����
 *
 * @author Hu.Sir
 */
public class Get implements RequestMethod{


    /**
     * ����������GET����
     *
     * @param sUrl ����URL: String
     * @return Jresponse ����
     */
    @Override
    public Jresponse sendRequest(@NotNull String sUrl) {
        // ��ȡһ������
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl, "GET");
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
    @Override
    public Jresponse sendRequest(@NotNull String sUrl, JSONObject headers) {
        // ��ȡһ������
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl, "GET");
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
