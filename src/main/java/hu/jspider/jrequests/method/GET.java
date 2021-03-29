package hu.jspider.jrequests.method;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jrequests.entity.Jresponse;
import hu.jspider.jrequests.entity.model.JresponseModel;
import hu.jspider.jrequests.util.JrequestsUtil;

import java.net.HttpURLConnection;

/**
 * GET 请求
 *
 * @author Hu.Sir
 */
public class GET {
    /**
     * 带参数的GET请求
     *
     * @param sUrl   请求url
     * @param params 请求参数
     * @return Jresponse对象
     */
    public Jresponse getJresponseWithParams(String sUrl, JSONObject params) {
        // 将参数拼接到请求链接
        String realUrl;
        if (params != null) {
            realUrl = JrequestsUtil.getRealUrl(sUrl, params);
        } else {
            realUrl = sUrl;
        }

        // 获取一个连接
        HttpURLConnection httpUrlConnection = Request.getConnection(realUrl);
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
    public Jresponse getJresponseWithHeaders(String sUrl, JSONObject headers) {
        // 获取一个连接
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl);
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
