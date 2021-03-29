package hu.jspider.jrequests.entity;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jrequests.service.RequestsService;
import hu.jspider.jrequests.util.StringUtil;

/**
 * Jrequests实体类
 *
 * @author Hu.Sir
 */
public class Jrequests {
    public static String encode;

    public Jrequests() {
        encode = "UTF-8";
    }

    public Jrequests(String encode) {
        Jrequests.encode = encode;
    }

    /**
     * 不带参数的GET请求
     *
     * @param sUrl 请求URL: String
     * @return Jresponse 对象
     */
    public Jresponse get(String sUrl) {
        return new RequestsService().getJresponseByGet(sUrl);
    }

    /**
     * 带参数的GET请求
     *
     * @param sUrl       请求URL: String
     * @param jsonObject 请求参数：JSONObject
     * @return Jresponse 对象
     */
    public Jresponse get(String sUrl, JSONObject jsonObject) {
        String flag = "user-agent";
        if (StringUtil.isExistIgnoreCase(jsonObject.keySet(), flag)) {
            return new RequestsService().getJresponseByGetWithHeaders(sUrl, jsonObject);
        } else {
            return new RequestsService().getJresponseByGetWithParams(sUrl, jsonObject);
        }
    }

    /**
     * 不带请求体POST请求
     *
     * @param sUrl 请求URL String
     * @return Jresponse 对象
     */
    public Jresponse post(String sUrl) {
        return new RequestsService().getJresponseByPost(sUrl);
    }

    /**
     * 带请求体的POST请求
     *
     * @param sUrl 请求URL: String
     * @param json 请求体
     * @return Jresponse 对象
     */
    public Jresponse post(String sUrl, String json) {
        return new RequestsService().getJresponseByPost(sUrl, json);
    }

    public Jresponse post(String sUrl, JSONObject headers, String data) {
        return new RequestsService().getJresponseByPost(sUrl, headers, data);
    }
}
