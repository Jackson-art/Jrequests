package com.jrequests.entity.model;

import com.alibaba.fastjson.JSONObject;
import com.jrequests.entity.Jresponse;
import com.jrequests.service.method.Request;
import com.jrequests.util.JrequestsUtil;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * 返回体设置模型
 *
 * @author Hu.Sir
 */
public class JresponseModel {
    private static final Logger logger = Logger.getLogger(Class.class);

    public static Jresponse getJresponse(HttpURLConnection httpUrlConnection) {
        Jresponse jresponse = new Jresponse();
        // 获取请求头
        JSONObject headers = Request.getResponseHeaders(httpUrlConnection);
        jresponse.setHeaders(headers);
        try {
            jresponse.setStatusCode(httpUrlConnection.getResponseCode());
        } catch (IOException e) {
            logger.error("失败或中断的 I/O 操作。");
        }
        jresponse.setText(JrequestsUtil.getText(httpUrlConnection));
        jresponse.setUrl(httpUrlConnection.getURL());
        return jresponse;
    }
}
