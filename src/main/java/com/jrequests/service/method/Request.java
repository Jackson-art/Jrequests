package com.jrequests.service.method;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ����ʵ��
 *
 * @author Hu.Sir
 */
public class Request {
    private static final Logger logger = Logger.getLogger(Class.class);

    public static HttpURLConnection getConnection(String sUrl) {
        URL url = null;
        try {
            url = new URL(sUrl);
        } catch (MalformedURLException e) {
            logger.error("�����URL: �ڹ淶�ַ������Ҳ����κκϷ�Э�� / �޷������ַ�����");
        }
        HttpURLConnection httpUrlConnection = null;
        try {
            assert url != null;
            httpUrlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            logger.error("ʧ�ܻ��жϵ� I/O ������");
        }
        return httpUrlConnection;
    }
}
