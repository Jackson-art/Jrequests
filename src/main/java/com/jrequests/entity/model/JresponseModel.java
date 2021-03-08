package com.jrequests.entity.model;

import com.jrequests.entity.Jresponse;
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
        try {
            assert httpUrlConnection != null;
            jresponse.setStatusCode(httpUrlConnection.getResponseCode());
        } catch (IOException e) {
            logger.error("ʧ�ܻ��жϵ� I/O ������");
        }
        jresponse.setText(JrequestsUtil.getText(httpUrlConnection));
        jresponse.setUrl(httpUrlConnection.getURL());
        return jresponse;
    }
}
