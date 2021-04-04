package hu.jspider.jrequests.method;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jlogger.JLogger;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * ����ʵ��
 *
 * @author Jackson-art
 */
public class Request {
    /**
     * ��־����
     */
    private static final JLogger LOGGER = JLogger.getLogger();

    /**
     * ��ȡһ����������
     *
     * @param sUrl ��������
     * @return HttpURLConnection����
     */
    public static HttpURLConnection getConnection(String sUrl, String method) {
        // ����һ��URL����
        URL url = null;
        try {
            url = new URL(sUrl);
        } catch (MalformedURLException e) {
            LOGGER.error("�½�һ��URL����", "�����URL: �ڹ淶�ַ������Ҳ����κκϷ�Э�� / �޷������ַ�����");
        }
        // ����һ������
        HttpURLConnection httpUrlConnection = null;
        try {
            assert url != null;
            httpUrlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            LOGGER.error("����������", "ʧ�ܻ��жϵ� I/O ������");
        }
        // ��������ʽ
        try {
            assert httpUrlConnection != null;
            httpUrlConnection.setRequestMethod(method.toUpperCase(Locale.ROOT));
        } catch (ProtocolException e) {
            LOGGER.warn("��������ʽ", "����ʽ����ʧ�ܣ�");
        }
        return httpUrlConnection;
    }

    /**
     * ��ȡ��Ӧͷ��Ϣ
     *
     * @param httpUrlConnection ��������
     * @return ��������ͷ��JSONObject
     */
    public static JSONObject getResponseHeaders(HttpURLConnection httpUrlConnection) {
        JSONObject responseHeaders = new JSONObject();
        final int headerNum = httpUrlConnection.getHeaderFields().keySet().toArray().length;
        for (int i = 0; i < headerNum; i++) {
            if (httpUrlConnection.getHeaderFieldKey(i) != null) {
                responseHeaders.put(httpUrlConnection.getHeaderFieldKey(i), httpUrlConnection.getHeaderField(i));
            }
        }
        return responseHeaders;
    }

    /**
     * ��ȡ����ͷ��Ϣ
     *
     * @param httpUrlConnection ��������
     * @return ��������ͷ��JSONObject
     */
    public static JSONObject getRequestHeaders(HttpURLConnection httpUrlConnection) {
        httpUrlConnection.disconnect();
        JSONObject requestsHeaders = new JSONObject();
        Map<String, List<String>> requestProperties = httpUrlConnection.getRequestProperties();
        for (String k : requestProperties.keySet()) {
            requestsHeaders.put(k, requestProperties.get(k).get(0));
        }
        return requestsHeaders;
    }

}
