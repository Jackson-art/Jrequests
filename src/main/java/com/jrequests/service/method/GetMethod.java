package com.jrequests.service.method;

import com.alibaba.fastjson.JSONObject;
import com.jrequests.entity.Jresponse;
import com.jrequests.entity.model.JresponseModel;
import com.jrequests.util.JrequestsUtil;

import java.net.HttpURLConnection;

/**
 * GET 请求
 *
 * @author Hu.Sir
 */
public class GetMethod {
    public Jresponse getJresponseObject(String sUrl, JSONObject params) {
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

}
