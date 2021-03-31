package hu.jspider.jrequests;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jparse.Jparse;
import hu.jspider.jrequests.impl.ResponseImpl;

import java.net.URL;

/**
 * @author Hu.Sir
 */
public class Jresponse implements ResponseImpl {

    private String text;
    private Integer statusCode;
    private URL url;
    private JSONObject responseHeaders;
    private JSONObject requestsHeaders;

    public Jresponse() {
    }

    public Jresponse(String text, Integer statusCode, URL url, JSONObject requestsHeaders, JSONObject responseHeaders) {
        this.text = text;
        this.statusCode = statusCode;
        this.url = url;
        this.responseHeaders = responseHeaders;
        this.requestsHeaders = requestsHeaders;
    }

    /**
     * ��ȡ�������ʵURL
     *
     * @return URL����
     */
    @Override
    public URL getUrl() {
        return url;
    }

    /**
     * ��ȡ��Ӧ��JSON����
     *
     * @return ��Ӧ��: JSONObject
     */
    @Override
    public JSONObject getJson() {
        return JSONObject.parseObject(text);
    }

    /**
     * ��ȡ��ҳԴ��
     *
     * @return ��ҳԴ��: String
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * ��ȡ����״̬��
     *
     * @return ����״̬��: Integer
     */
    @Override
    public Integer getStatusCode() {
        return statusCode;
    }

    /**
     * ��ȡ����ͷ
     *
     * @return ��ȡ����ͷ: JSONObject
     */
    @Override
    public JSONObject getRequestsHeaders() {
        return requestsHeaders;
    }

    /**
     * ��ȡ����ͷ�ֶε�ֵ
     *
     * @param key ��Ӧͷ�еļ�: String
     * @return ��Ӧ��ֵ
     */
    @Override
    public String getRequestsHeader(String key) {
        return responseHeaders.getString(key);
    }

    /**
     * ��ȡ��Ӧͷ
     *
     * @return ��Ӧͷ: JSONObject
     */
    @Override
    public JSONObject getResponseHeaders() {
        return responseHeaders;
    }

    /**
     * ��ȡ��Ӧͷ�ֶε�ֵ
     *
     * @param key ��Ӧͷ�еļ�: String
     * @return ��Ӧ��ֵ
     */
    @Override
    public String getResponseHeader(String key) {
        return responseHeaders.getString(key);
    }


    /**
     * ͨ��XPath������ҳ
     *
     * @param xpath XPath�﷨
     * @return �������Ķ���
     */
    public Object parseByXpath(String xpath) {
        return new Jparse().getObjectByXpath(this.text, xpath);
    }

}
