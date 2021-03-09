package com.jrequests.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ��ҳԴ���ȡ����
 *
 * @author Hu.Sir
 */
public class JrequestsUtil {
    /**
     * Logger ��־����
     */
    private static final Logger logger = Logger.getLogger(Class.class);

    /**
     * ��ȡƴ����ҳԴ��
     *
     * @param httpUrlConnection �������� : HttpURLConnection
     * @return ��ҳԴ�� : String
     */
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

    /**
     * ��ȡƴ�Ӳ������URL
     *
     * @param sUrl   ����Ĳ���URL: String
     * @param params �������: JSONObject
     * @return ƴ�Ӻ��URL: String
     */
    public static String getRealUrl(String sUrl, JSONObject params) {
        boolean isFirst = true;
        StringBuilder realUrl = new StringBuilder();
        realUrl.append(sUrl).append("?");
        for (String str : params.keySet()) {
            if (isFirst) {
                realUrl.append(str).append("=").append(getUrlEncode(params.getString(str)));
                isFirst = false;
            } else {
                realUrl.append("&").append(str).append("=").append(getUrlEncode(params.getString(str)));
            }
        }
        return realUrl.toString();
    }

    /**
     * URL�����е����Ľ��б���
     *
     * @param str �����ĵ��ַ�����String
     * @return �������ַ���
     */
    private static String getUrlEncode(String str) {
        final Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        final Matcher m = p.matcher(str);
        if (m.find()) {
            String reStr = "";
            try {
                reStr = URLEncoder.encode(str, "GBK");
            } catch (UnsupportedEncodingException e) {
                logger.error("��֧���ַ�����!");
            }
            return reStr.trim();
        }
        return str.trim();
    }

}

