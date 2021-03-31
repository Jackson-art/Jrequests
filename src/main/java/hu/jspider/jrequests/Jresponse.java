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
     * 获取请求的真实URL
     *
     * @return URL对象
     */
    @Override
    public URL getUrl() {
        return url;
    }

    /**
     * 获取响应体JSON对象
     *
     * @return 响应体: JSONObject
     */
    @Override
    public JSONObject getJson() {
        return JSONObject.parseObject(text);
    }

    /**
     * 获取网页源码
     *
     * @return 网页源码: String
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * 获取请求状态码
     *
     * @return 请求状态码: Integer
     */
    @Override
    public Integer getStatusCode() {
        return statusCode;
    }

    /**
     * 获取请求头
     *
     * @return 获取请求头: JSONObject
     */
    @Override
    public JSONObject getRequestsHeaders() {
        return requestsHeaders;
    }

    /**
     * 获取请求头字段的值
     *
     * @param key 响应头中的键: String
     * @return 对应的值
     */
    @Override
    public String getRequestsHeader(String key) {
        return responseHeaders.getString(key);
    }

    /**
     * 获取响应头
     *
     * @return 响应头: JSONObject
     */
    @Override
    public JSONObject getResponseHeaders() {
        return responseHeaders;
    }

    /**
     * 获取响应头字段的值
     *
     * @param key 响应头中的键: String
     * @return 对应的值
     */
    @Override
    public String getResponseHeader(String key) {
        return responseHeaders.getString(key);
    }


    /**
     * 通过XPath解析网页
     *
     * @param xpath XPath语法
     * @return 解析出的对象
     */
    public Object parseByXpath(String xpath) {
        return new Jparse().getObjectByXpath(this.text, xpath);
    }

}
