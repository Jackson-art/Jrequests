package hu.jspider.jrequests.method;

import com.alibaba.fastjson.JSONObject;
import com.sun.istack.internal.NotNull;
import hu.jspider.jlogger.JLogger;
import hu.jspider.jrequests.impl.Jresponse;
import hu.jspider.jrequests.entity.JresponseModel;
import hu.jspider.jrequests.util.StringUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

/**
 * POST ����
 *
 * @author Hu.Sir
 */
public class Post implements RequestMethod {
    /**
     * ��־����
     */
    private final JLogger LOGGER = JLogger.getLogger();

    /**
     * ��������POST����
     *
     * @param sUrl ����URL: String
     * @return Jresponse ����
     */
    @Override
    public Jresponse sendRequest(@NotNull String sUrl) {
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl, "POST");
        Jresponse jresponse = JresponseModel.getJresponse(httpUrlConnection);
        httpUrlConnection.disconnect();
        return jresponse;
    }

    /**
     * ������ͷ��POST����
     *
     * @param sUrl       ����url
     * @param jsonObject �������
     * @return Jresponse����
     */
    @Override
    public Jresponse sendRequest(@NotNull String sUrl, JSONObject jsonObject) {
        // ��ȡһ������
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl, "POST");

        String flag = "user-agent";
        // �жϲ����Ƿ�Ϊ����ͷ
        if (StringUtil.isExistIgnoreCase(jsonObject.keySet(), flag)) {
            // ��������ͷ
            for (String k : jsonObject.keySet()) {
                httpUrlConnection.setRequestProperty(k, jsonObject.getString(k));
            }
        } else {
            // ����������
            setRequestBody(httpUrlConnection, jsonObject.toJSONString());
        }

        // ��ȡ���������
        Jresponse jresponse = JresponseModel.getJresponse(httpUrlConnection);
        httpUrlConnection.disconnect();
        return jresponse;
    }

    /**
     * ������������GET����
     *
     * @param sUrl        ����URL: String
     * @param jsonObject1 ���������JSONObject
     * @param jsonObject2 ���������JSONObject
     * @return Jresponse ����
     */
    public Jresponse sendRequest(@NotNull String sUrl, JSONObject jsonObject1, JSONObject jsonObject2) {
        // ��ȡһ������
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl, "POST");

        String flag = "user-agent";
        // �жϲ����Ƿ�Ϊ����ͷ
        if (StringUtil.isExistIgnoreCase(jsonObject1.keySet(), flag)) {
            // ��������ͷ
            for (String k : jsonObject1.keySet()) {
                httpUrlConnection.setRequestProperty(k, jsonObject1.getString(k));
            }
            // ����������
            setRequestBody(httpUrlConnection, jsonObject2.toJSONString());
        } else {
            // ��������ͷ
            for (String k : jsonObject2.keySet()) {
                httpUrlConnection.setRequestProperty(k, jsonObject2.getString(k));
            }
            // ����������
            setRequestBody(httpUrlConnection, jsonObject1.toJSONString());
        }

        // ��ȡ���������
        Jresponse jresponse = JresponseModel.getJresponse(httpUrlConnection);
        httpUrlConnection.disconnect();
        return jresponse;
    }


    /**
     * ���������
     *
     * @param httpUrlConnection ��������
     * @param requestBody       ������
     */
    private void setRequestBody(HttpURLConnection httpUrlConnection, String requestBody) {
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
            outputStream.write(requestBody.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        } catch (IOException e) {
            LOGGER.error("����������", e);
        }
    }
}
