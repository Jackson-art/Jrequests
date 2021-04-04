package hu.jspider.jrequests.method;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jlogger.JLogger;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * 请求实体
 *
 * @author Jackson-art
 */
public class Request {
    /**
     * 日志对象
     */
    private static final JLogger LOGGER = JLogger.getLogger();

    /**
     * 获取一个请求连接
     *
     * @param sUrl 请求链接
     * @return HttpURLConnection对象
     */
    public static HttpURLConnection getConnection(String sUrl, String method) {
        // 创建一个URL对象
        URL url = null;
        try {
            url = new URL(sUrl);
        } catch (MalformedURLException e) {
            LOGGER.error("新建一个URL对象", "错误的URL: 在规范字符串中找不到任何合法协议 / 无法解析字符串。");
        }
        // 建立一个连接
        HttpURLConnection httpUrlConnection = null;
        try {
            assert url != null;
            httpUrlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            LOGGER.error("打开请求连接", "失败或中断的 I/O 操作。");
        }
        // 设置请求方式
        try {
            assert httpUrlConnection != null;
            httpUrlConnection.setRequestMethod(method.toUpperCase(Locale.ROOT));
        } catch (ProtocolException e) {
            LOGGER.warn("设置请求方式", "请求方式设置失败！");
        }
        return httpUrlConnection;
    }

    /**
     * 获取响应头信息
     *
     * @param httpUrlConnection 请求连接
     * @return 所有请求头：JSONObject
     */
    public static JSONObject getResponseHeaders(HttpURLConnection httpUrlConnection) {
        JSONObject responseHeaders = new JSONObject();
        final int headerNum = httpUrlConnection.getHeaderFields().keySet().toArray().length;
        for (int i = 0; i < headerNum; i++) {
            if (httpUrlConnection.getHeaderFieldKey(i) != null) {
                responseHeaders.put(httpUrlConnection.getHeaderFieldKey(i), httpUrlConnection.getHeaderField(i));
            }
        }
        return responseHeaders;
    }

    /**
     * 获取请求头信息
     *
     * @param httpUrlConnection 请求连接
     * @return 所有请求头：JSONObject
     */
    public static JSONObject getRequestHeaders(HttpURLConnection httpUrlConnection) {
        httpUrlConnection.disconnect();
        JSONObject requestsHeaders = new JSONObject();
        Map<String, List<String>> requestProperties = httpUrlConnection.getRequestProperties();
        for (String k : requestProperties.keySet()) {
            requestsHeaders.put(k, requestProperties.get(k).get(0));
        }
        return requestsHeaders;
    }

}
