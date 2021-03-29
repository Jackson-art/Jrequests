package hu.jspider.jrequests.service;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jrequests.entity.Jresponse;
import hu.jspider.jrequests.method.GET;
import hu.jspider.jrequests.method.POST;

/**
 * 请求网页
 *
 * @author Hu.Sir
 */
public class RequestsService {

    /**
     * 不带参数的GET请求
     *
     * @param sUrl 请求URL: String
     * @return Jresponse 对象
     */
    public Jresponse getJresponseByGet(String sUrl) {
        return new GET().getJresponseWithParams(sUrl, null);
    }

    /**
     * 带参数的GET请求
     *
     * @param sUrl   请求URL: String
     * @param params 请求参数：JSONObject
     * @return Jresponse 对象
     */
    public Jresponse getJresponseByGetWithParams(String sUrl, JSONObject params) {
        return new GET().getJresponseWithParams(sUrl, params);
    }

    /**
     * 带请求头的GET请求
     *
     * @param sUrl    请求URL: String
     * @param headers 请求参数：JSONObject
     * @return Jresponse 对象
     */
    public Jresponse getJresponseByGetWithHeaders(String sUrl, JSONObject headers) {
        return new GET().getJresponseWithHeaders(sUrl, headers);
    }

    /**
     * 不带请求体POST请求
     *
     * @param sUrl 请求URL String
     * @return Jresponse 对象
     */
    public Jresponse getJresponseByPost(String sUrl) {
        return new POST().getJresponseObject(sUrl, null);
    }

    /**
     * 带请求体的POST请求
     *
     * @param sUrl 请求URL: String
     * @param json 请求体
     * @return Jresponse 对象
     */
    public Jresponse getJresponseByPost(String sUrl, String json) {
        return new POST().getJresponseObject(sUrl, json);
    }

    /**
     * 带请求体和请求头的POST请求
     *
     * @param sUrl    请求URL: String
     * @param headers 请求头
     * @param data    请求体
     * @return Jresponse 对象
     */
    public Jresponse getJresponseByPost(String sUrl, JSONObject headers, String data) {
        return new POST().getJresponseObject(sUrl, headers, data);
    }
}