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
 * POST 请求
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
            logger.warn("POST 请求方式设置失败！");
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
        // 设置是否向httpUrlConnection输出，post请求设置为true，默认是false
        httpUrlConnection.setDoOutput(true);
        // 设置RequestBody
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(httpUrlConnection.getOutputStream());
        } catch (IOException e) {
            logger.error("失败或中断的 I/O 操作。");
        }
        assert printWriter != null;
        printWriter.write(json.toJSONString());
        printWriter.flush();
    }
}
