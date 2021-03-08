package com.jrequests.service.method;

import com.jrequests.entity.Jresponse;
import com.jrequests.entity.model.JresponseModel;

import java.net.HttpURLConnection;

/**
 * GET 请求
 *
 * @author Hu.Sir
 */
public class GetMethod {
    public Jresponse getJresponseObject(String sUrl) {
        // 获取一个连接
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl);
        // 获取返回体对象
        Jresponse jresponse = JresponseModel.getJresponse(httpUrlConnection);
        httpUrlConnection.disconnect();
        return jresponse;
    }
}
