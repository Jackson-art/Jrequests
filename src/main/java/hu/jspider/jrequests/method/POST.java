package hu.jspider.jrequests.method;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jlogger.JLogger;
import hu.jspider.jrequests.entity.Jresponse;
import hu.jspider.jrequests.entity.model.JresponseModel;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.nio.charset.StandardCharsets;

/**
 * POST ����
 *
 * @author Hu.Sir
 */
public class POST {
    /**
     * ��־����
     */
    private final JLogger LOGGER = JLogger.getLogger();

    public Jresponse getJresponseObject(String sUrl, String json) {
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl);

        try {
            assert httpUrlConnection != null;
            httpUrlConnection.setRequestMethod("POST");
        } catch (ProtocolException e) {
            LOGGER.warn("��������ʽΪPOST", "POST ����ʽ����ʧ�ܣ�");
        }
        httpUrlConnection.setRequestProperty("content-type", "application/json;charset=UTF-8");
        if (json != null) {
            setRequestBody(httpUrlConnection, json);
        }
        Jresponse jresponse = JresponseModel.getJresponse(httpUrlConnection);
        httpUrlConnection.disconnect();
        return jresponse;
    }

    /**
     * ���������
     *
     * @param httpUrlConnection ��������
     * @param json              ������
     */
    private void setRequestBody(HttpURLConnection httpUrlConnection, String json) {
        // �����Ƿ���httpUrlConnection�����post��������Ϊtrue��Ĭ����false
        httpUrlConnection.setDoOutput(true);
        // ����RequestBody
        OutputStream outputStream = null;
        try {
            outputStream = httpUrlConnection.getOutputStream();
        } catch (IOException e) {
            LOGGER.error("���������", "ʧ�ܻ��жϵ� I/O ������");
        }
        try {
            assert outputStream != null;
            outputStream.write(json.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        } catch (IOException e) {
            LOGGER.error("����������", e);
        }

    }

    public Jresponse getJresponseObject(String sUrl, JSONObject headers, String data) {
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl);

        try {
            assert httpUrlConnection != null;
            httpUrlConnection.setRequestMethod("POST");
        } catch (ProtocolException e) {
            LOGGER.warn("��������ʽΪPOST", "POST ����ʽ����ʧ�ܣ�");
        }
        httpUrlConnection.setUseCaches(false);
        for (String k : headers.keySet()) {
            httpUrlConnection.setRequestProperty(k, headers.getString(k));
        }


        setRequestBody(httpUrlConnection, data);
        Jresponse jresponse = JresponseModel.getJresponse(httpUrlConnection);
        httpUrlConnection.disconnect();
        return jresponse;
    }
}
