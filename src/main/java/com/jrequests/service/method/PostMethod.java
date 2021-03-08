package com.jrequests.service.method;

import com.alibaba.fastjson.JSONObject;
import com.jrequests.entity.Jresponse;
import com.jrequests.entity.model.JresponseModel;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

/**
 * POST ����
 *
 * @author Hu.Sir
 */
public class PostMethod {
    private final Logger logger = Logger.getLogger(Class.class);

    public Jresponse getJresponseObject(String sUrl, JSONObject json) {
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl);

        try {
            assert httpUrlConnection != null;
            httpUrlConnection.setRequestMethod("POST");
        } catch (ProtocolException e) {
            logger.warn("POST ����ʽ����ʧ�ܣ�");
        }
        httpUrlConnection.setRequestProperty("Content-Type", "application/json");

        if (json != null) {
            setConnection(httpUrlConnection, json);
        }
        Jresponse jresponse = JresponseModel.getJresponse(httpUrlConnection);
        httpUrlConnection.disconnect();
        return jresponse;
    }

    public void setConnection(HttpURLConnection httpUrlConnection, JSONObject json) {
        // �����Ƿ���httpUrlConnection�����post��������Ϊtrue��Ĭ����false
        httpUrlConnection.setDoOutput(true);
        // ����RequestBody
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(httpUrlConnection.getOutputStream());
        } catch (IOException e) {
            logger.error("ʧ�ܻ��жϵ� I/O ������");
        }
        assert printWriter != null;
        printWriter.write(json.toJSONString());
        printWriter.flush();
    }
}
