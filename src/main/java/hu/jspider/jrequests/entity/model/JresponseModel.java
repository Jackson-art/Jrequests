package hu.jspider.jrequests.entity.model;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jlogger.JLogger;
import hu.jspider.jrequests.entity.Jresponse;
import hu.jspider.jrequests.method.Request;
import hu.jspider.jrequests.util.JrequestsUtil;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ����������ģ��
 *
 * @author Hu.Sir
 */
public class JresponseModel {
    private static final JLogger LOGGER = JLogger.getLogger();

    public static Jresponse getJresponse(HttpURLConnection httpUrlConnection) {
        JSONObject requestsHeaders = Request.getRequestHeaders(httpUrlConnection);
        JSONObject responseHeaders = Request.getResponseHeaders(httpUrlConnection);

        int code = 0;
        try {
            code = httpUrlConnection.getResponseCode();
        } catch (IOException e) {
            LOGGER.error("��ȡ������Ӧ��", "ʧ�ܻ��жϵ� I/O ������");
        }
        String text = JrequestsUtil.getText(httpUrlConnection);
        URL url = httpUrlConnection.getURL();
        return new Jresponse(text, code, url, requestsHeaders, responseHeaders);
    }
}
