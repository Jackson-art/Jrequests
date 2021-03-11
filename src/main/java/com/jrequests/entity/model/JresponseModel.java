package com.jrequests.entity.model;

import com.alibaba.fastjson.JSONObject;
import com.jrequests.entity.Jresponse;
import com.jrequests.service.method.Request;
import com.jrequests.util.JrequestsUtil;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * ����������ģ��
 *
 * @author Hu.Sir
 */
public class JresponseModel {
    private static final Logger logger = Logger.getLogger(Class.class);

    public static Jresponse getJresponse(HttpURLConnection httpUrlConnection) {
        Jresponse jresponse = new Jresponse();
        // ��ȡ����ͷ
        JSONObject headers = Request.getResponseHeaders(httpUrlConnection);
        jresponse.setHeaders(headers);
        try {
            jresponse.setStatusCode(httpUrlConnection.getResponseCode());
        } catch (IOException e) {
            logger.error("ʧ�ܻ��жϵ� I/O ������");
        }
        jresponse.setText(JrequestsUtil.getText(httpUrlConnection));
        jresponse.setUrl(httpUrlConnection.getURL());
        return jresponse;
    }
}
