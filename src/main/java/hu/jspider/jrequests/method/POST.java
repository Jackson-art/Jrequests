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
 * POST 请求
 *
 * @author Hu.Sir
 */
public class POST {
    /**
     * 日志对象
     */
    private final JLogger LOGGER = JLogger.getLogger();

    public Jresponse getJresponseObject(String sUrl, String json) {
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl);

        try {
            assert httpUrlConnection != null;
            httpUrlConnection.setRequestMethod("POST");
        } catch (ProtocolException e) {
            LOGGER.warn("设置请求方式为POST", "POST 请求方式设置失败！");
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
     * 添加请求体
     *
     * @param httpUrlConnection 请求连接
     * @param json              请求体
     */
    private void setRequestBody(HttpURLConnection httpUrlConnection, String json) {
        // 设置是否向httpUrlConnection输出，post请求设置为true，默认是false
        httpUrlConnection.setDoOutput(true);
        // 设置RequestBody
        OutputStream outputStream = null;
        try {
            outputStream = httpUrlConnection.getOutputStream();
        } catch (IOException e) {
            LOGGER.error("添加请求体", "失败或中断的 I/O 操作。");
        }
        try {
            assert outputStream != null;
            outputStream.write(json.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        } catch (IOException e) {
            LOGGER.error("设置请求体", e);
        }

    }

    public Jresponse getJresponseObject(String sUrl, JSONObject headers, String data) {
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl);

        try {
            assert httpUrlConnection != null;
            httpUrlConnection.setRequestMethod("POST");
        } catch (ProtocolException e) {
            LOGGER.warn("设置请求方式为POST", "POST 请求方式设置失败！");
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
