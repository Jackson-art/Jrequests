package hu.jspider.jrequests.impl;

import com.alibaba.fastjson.JSONObject;

import java.net.URL;

/**
 * 请求体接口
 *
 * @author Hu.Sir
 */
public interface ResponseImpl {

    /**
     * 获取请求的真实URL
     *
     * @return URL对象
     */
    URL getUrl();

    /**
     * 获取响应体JSON对象
     *
     * @return 响应体: JSONObject
     */
    JSONObject getJson();

    /**
     * 获取网页源码
     *
     * @return 网页源码: String
     */
    String getText();

    /**
     * 获取请求状态码
     *
     * @return 请求状态码: Integer
     */
    Integer getStatusCode();


    /**
     * 获取请求头
     *
     * @return 获取请求头: JSONObject
     */
    JSONObject getRequestsHeaders();

    /**
     * 获取请求头字段的值
     *
     * @param key 响应头中的键: String
     * @return 对应的值
     */
    String getRequestsHeader(String key);

    /**
     * 获取响应头
     *
     * @return 响应头: JSONObject
     */
    JSONObject getResponseHeaders();

    /**
     * 获取响应头字段的值
     *
     * @param key 响应头中的键: String
     * @return 对应的值
     */
    String getResponseHeader(String key);

}
