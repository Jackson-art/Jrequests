package com.jrequests.entity;

import com.alibaba.fastjson.JSONObject;

import java.net.URL;

/**
 * @author Hu.Sir
 */
public class Jresponse {

    private String text;
    private Integer statusCode;
    private URL url;
    private JSONObject headers;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }

    public void setHeaders(JSONObject headers) {
        this.headers = headers;
    }

    public JSONObject getHeaders() {
        return headers;
    }
}
