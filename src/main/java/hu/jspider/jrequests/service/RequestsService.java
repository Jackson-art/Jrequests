package hu.jspider.jrequests.service;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jrequests.Jresponse;
import hu.jspider.jrequests.method.Get;
import hu.jspider.jrequests.method.Post;
import hu.jspider.jrequests.util.JrequestsUtil;
import hu.jspider.jrequests.util.StringUtil;

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
    public Jresponse sendRequestByGet(String sUrl) {
        return new Get().sendRequest(sUrl);
    }

    /**
     * 带参数的GET请求
     *
     * @param sUrl       请求URL: String
     * @param jsonObject 请求参数：JSONObject
     * @return Jresponse 对象
     */
    public Jresponse sendRequestByGet(String sUrl, JSONObject jsonObject) {
        String flag = "user-agent";
        // 判断参数是否为请求头
        if (StringUtil.isExistIgnoreCase(jsonObject.keySet(), flag)) {
            return new Get().sendRequest(sUrl, jsonObject);
        } else {
            return new Get().sendRequest(JrequestsUtil.getRealUrl(sUrl, jsonObject));
        }
    }

    /**
     * 带两个参数的GET请求
     *
     * @param sUrl        请求URL: String
     * @param jsonObject1 请求参数：JSONObject
     * @param jsonObject2 请求参数：JSONObject
     * @return Jresponse 对象
     */
    public Jresponse sendRequestByGet(String sUrl, JSONObject jsonObject1, JSONObject jsonObject2) {
        String flag = "user-agent";
        // 判断参数是否为请求头
        if (StringUtil.isExistIgnoreCase(jsonObject1.keySet(), flag)) {
            // 若jsonObject1为请求头
            return new Get().sendRequest(JrequestsUtil.getRealUrl(sUrl, jsonObject1), jsonObject2);
        } else {
            // 若jsonObject2为请求头
            return new Get().sendRequest(JrequestsUtil.getRealUrl(sUrl, jsonObject2), jsonObject1);
        }
    }


    /*===========================================    分 界 线    ===========================================*/


    /**
     * 不带参数的POST请求
     *
     * @param sUrl 请求URL: String
     * @return Jresponse 对象
     */
    public Jresponse sendRequestByPost(String sUrl) {
        return new Post().sendRequest(sUrl);
    }

    /**
     * 带一个参数的POST请求
     *
     * @param sUrl       请求URL: String
     * @param jsonObject 请求参数: JSONObject
     * @return Jresponse 对象
     */
    public Jresponse sendRequestByPost(String sUrl, JSONObject jsonObject) {
        return new Post().sendRequest(sUrl, jsonObject);
    }

    /**
     * 带两个参数的GET请求
     *
     * @param sUrl        请求URL: String
     * @param jsonObject1 请求参数：JSONObject
     * @param jsonObject2 请求参数：JSONObject
     * @return Jresponse 对象
     */
    public Jresponse sendRequestByPost(String sUrl, JSONObject jsonObject1, JSONObject jsonObject2) {
        return new Post().sendRequest(sUrl, jsonObject1, jsonObject2);
    }

}