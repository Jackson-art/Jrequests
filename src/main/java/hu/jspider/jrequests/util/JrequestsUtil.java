package hu.jspider.jrequests.util;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jlogger.JLogger;
import hu.jspider.jrequests.entity.Jrequests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ��ҳԴ���ȡ����
 *
 * @author Hu.Sir
 */
public class JrequestsUtil {
    /**
     * JLogger ��־����
     */
    private static final JLogger LOGGER = JLogger.getLogger();

    /**
     * ��ȡƴ����ҳԴ��
     *
     * @param httpUrlConnection �������� : HttpURLConnection
     * @return ��ҳԴ�� : String
     */
    public static String getText(HttpURLConnection httpUrlConnection) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream(), Jrequests.encode));
        } catch (IOException e) {
            LOGGER.error("��ȡ��ҳԴ��", "ʧ�ܻ��жϵ� I/O ������");
        }
        String lines;
        StringBuilder text = new StringBuilder();
        try {
            while (true) {
                assert reader != null;
                if ((lines = reader.readLine()) == null) {
                    break;
                } else {
                    text.append(lines);
                }
            }
        } catch (IOException e) {
            LOGGER.error("ƴ����ҳԴ��", "��ȡ text ʧ�ܣ�");
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


    private final static Pattern P = Pattern.compile("[\u4e00-\u9fa5]");

    /**
     * URL�����е����Ľ��б���
     *
     * @param str �����ĵ��ַ�����String
     * @return �������ַ���
     */
    private static String getUrlEncode(String str) {
        final Matcher m = P.matcher(str);
        String tempStr = str.replaceAll(" ", "%20");
        if (m.find()) {
            String reStr = "";
            try {
                reStr = URLEncoder.encode(tempStr, "GBK");
            } catch (UnsupportedEncodingException e) {
                LOGGER.error("�����������ת��", "��֧���ַ�����!");
            }
            return reStr.trim();
        }
        return tempStr.trim();
    }


}

