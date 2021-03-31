package hu.jspider.jrequests.method;

import com.alibaba.fastjson.JSONObject;
import com.sun.istack.internal.NotNull;
import hu.jspider.jrequests.Jresponse;
import hu.jspider.jrequests.entity.JresponseModel;

import java.net.HttpURLConnection;

/**
 * Get 请求
 *
 * @author Hu.Sir
 */
public class Get implements RequestMethod{


    /**
     * 不带参数的GET请求
     *
     * @param sUrl 请求URL: String
     * @return Jresponse 对象
     */
    @Override
    public Jresponse sendRequest(@NotNull String sUrl) {
        // 获取一个连接
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl, "GET");
        // 获取返回体对象
        Jresponse jresponse = JresponseModel.getJresponse(httpUrlConnection);
        httpUrlConnection.disconnect();
        return jresponse;
    }

    /**
     * 带请求头的GET请求
     *
     * @param sUrl    请求url
     * @param headers 请求头
     * @return Jresponse对象
     */
    @Override
    public Jresponse sendRequest(@NotNull String sUrl, JSONObject headers) {
        // 获取一个连接
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl, "GET");
        // 设置请求头
        for (String k : headers.keySet()) {
            httpUrlConnection.setRequestProperty(k, headers.getString(k));
        }
        // 获取返回体对象
        Jresponse jresponse = JresponseModel.getJresponse(httpUrlConnection);
        httpUrlConnection.disconnect();
        return jresponse;
    }

}
