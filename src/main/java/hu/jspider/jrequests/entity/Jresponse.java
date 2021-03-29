package hu.jspider.jrequests.entity;

import com.alibaba.fastjson.JSONObject;

import java.net.URL;

/**
 * @author Hu.Sir
 */
public class Jresponse {

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


    public String getText() {
        return text;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public URL getUrl() {
        return url;
    }

    public JSONObject getResponseHeaders() {
        return responseHeaders;
    }

    public String getResponseHeader(String key) {
        return this.responseHeaders.getString(key);
    }

    public JSONObject getJson() {
        return JSONObject.parseObject(this.text);
    }

    public JSONObject getRequestsHeaders() {
        return requestsHeaders;
    }

    public String getRequestsHeader(String key) {
        return this.requestsHeaders.getString(key);
    }

}
