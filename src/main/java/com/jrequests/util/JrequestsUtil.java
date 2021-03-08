package com.jrequests.util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

/**
 * ��ҳԴ���ȡ����
 *
 * @author Hu.Sir
 */
public class JrequestsUtil {
    private static final Logger logger = Logger.getLogger(Class.class);

    public static String getText(HttpURLConnection httpUrlConnection) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.error("ʧ�ܻ��жϵ� I/O ������");
        }
        String lines;
        StringBuilder text = new StringBuilder();
        try {
            while (true) {
                assert reader != null;
                if ((lines = reader.readLine()) == null) {
                    break;
                }
                text.append(lines);
            }
        } catch (IOException e) {
            logger.error("��ȡ text ʧ�ܣ�");
        }
        return text.toString();
    }
}
