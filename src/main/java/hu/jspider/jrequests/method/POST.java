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
 * POST 请求
 *
 * @author Hu.Sir
 */
public class Post implements RequestMethod {
    /**
     * 日志对象
     */
    private final JLogger LOGGER = JLogger.getLogger();

    /**
     * 不带参数POST请求
     *
     * @param sUrl 请求URL: String
     * @return Jresponse 对象
     */
    @Override
    public Jresponse sendRequest(@NotNull String sUrl) {
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl, "POST");
        Jresponse jresponse = JresponseModel.getJresponse(httpUrlConnection);
        httpUrlConnection.disconnect();
        return jresponse;
    }

    /**
     * 带请求头的POST请求
     *
     * @param sUrl       请求url
     * @param jsonObject 请求参数
     * @return Jresponse对象
     */
    @Override
    public Jresponse sendRequest(@NotNull String sUrl, JSONObject jsonObject) {
        // 获取一个连接
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl, "POST");

        String flag = "user-agent";
        // 判断参数是否为请求头
        if (StringUtil.isExistIgnoreCase(jsonObject.keySet(), flag)) {
            // 设置请求头
            for (String k : jsonObject.keySet()) {
                httpUrlConnection.setRequestProperty(k, jsonObject.getString(k));
            }
        } else {
            // 设置请求体
            setRequestBody(httpUrlConnection, jsonObject.toJSONString());
        }

        // 获取返回体对象
        Jresponse jresponse = JresponseModel.getJresponse(httpUrlConnection);
        httpUrlConnection.disconnect();
        return jresponse;
    }

    /**
     * 带两个参数的GET请求
     *
     * @param sUrl        请求URL: String
     * @param jsonObject1 请求参数：JSONObject
     * @param jsonObject2 请求参数：JSONObject
     * @return Jresponse 对象
     */
    public Jresponse sendRequest(@NotNull String sUrl, JSONObject jsonObject1, JSONObject jsonObject2) {
        // 获取一个连接
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl, "POST");

        String flag = "user-agent";
        // 判断参数是否为请求头
        if (StringUtil.isExistIgnoreCase(jsonObject1.keySet(), flag)) {
            // 设置请求头
            for (String k : jsonObject1.keySet()) {
                httpUrlConnection.setRequestProperty(k, jsonObject1.getString(k));
            }
            // 设置请求体
            setRequestBody(httpUrlConnection, jsonObject2.toJSONString());
        } else {
            // 设置请求头
            for (String k : jsonObject2.keySet()) {
                httpUrlConnection.setRequestProperty(k, jsonObject2.getString(k));
            }
            // 设置请求体
            setRequestBody(httpUrlConnection, jsonObject1.toJSONString());
        }

        // 获取返回体对象
        Jresponse jresponse = JresponseModel.getJresponse(httpUrlConnection);
        httpUrlConnection.disconnect();
        return jresponse;
    }


    /**
     * 添加请求体
     *
     * @param httpUrlConnection 请求连接
     * @param requestBody       请求体
     */
    private void setRequestBody(HttpURLConnection httpUrlConnection, String requestBody) {
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
            outputStream.write(requestBody.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        } catch (IOException e) {
            LOGGER.error("设置请求体", e);
        }
    }
}
