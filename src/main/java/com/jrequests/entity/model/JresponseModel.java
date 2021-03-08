package com.jrequests.entity.model;

import com.jrequests.entity.Jresponse;
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
        try {
            assert httpUrlConnection != null;
            jresponse.setStatusCode(httpUrlConnection.getResponseCode());
        } catch (IOException e) {
            logger.error("失败或中断的 I/O 操作。");
        }
        jresponse.setText(JrequestsUtil.getText(httpUrlConnection));
        jresponse.setUrl(httpUrlConnection.getURL());
        return jresponse;
    }
}
