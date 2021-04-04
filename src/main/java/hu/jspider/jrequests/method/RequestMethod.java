package hu.jspider.jrequests.method;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jrequests.Jresponse;

/**
 * 请求方式接口
 *
 * @author Jackson-art
 */
public interface RequestMethod {

    /**
     * 不带参数的请求
     *
     * @param sUrl 请求URL: String
     * @return Jresponse 对象
     */
     Jresponse sendRequest(String sUrl);

    /**
     * 带请求头的请求
     *
     * @param sUrl    请求url
     * @param headers 请求头
     * @return Jresponse对象
     */
     Jresponse sendRequest(String sUrl, JSONObject headers);
}
