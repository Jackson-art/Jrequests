package hu.jspider.jrequests.impl;

import com.alibaba.fastjson.JSONObject;
import com.sun.istack.internal.NotNull;

/**
 * 请求接口
 *
 * @author Hu.Sir
 */
public interface RequestsImpl {

    /**
     * 不带参数的GET请求
     *
     * @param sUrl 请求URL: String
     * @return Jresponse 对象
     */
    Jresponse get(@NotNull String sUrl);

    /**
     * 带一个参数的GET请求
     *
     * @param sUrl       请求URL: String
     * @param jsonObject 请求参数：JSONObject
     * @return Jresponse 对象
     */
    Jresponse get(@NotNull String sUrl, JSONObject jsonObject);

    /**
     * 带两个参数的GET请求
     *
     * @param sUrl        请求URL: String
     * @param jsonObject1 请求参数：JSONObject
     * @param jsonObject2 请求参数：JSONObject
     * @return Jresponse 对象
     */
    Jresponse get(@NotNull String sUrl, JSONObject jsonObject1, JSONObject jsonObject2);

    /**
     * 多参数同时传递
     *
     * @param objects 所有参数
     * @return Jresponse 对象
     */
    Jresponse get(@NotNull Object... objects);

    /**
     * 不带参数POST请求
     *
     * @param sUrl 请求URL: String
     * @return Jresponse 对象
     */
    Jresponse post(@NotNull String sUrl);

    /**
     * 带一个参数的POST请求
     *
     * @param sUrl       请求URL: String
     * @param jsonObject 请求参数: JSONObject
     * @return Jresponse 对象
     */
    Jresponse post(@NotNull String sUrl, JSONObject jsonObject);

    /**
     * 带两个参数的POST请求
     *
     * @param sUrl        请求URL: String
     * @param jsonObject1 请求参数: JSONObject
     * @param jsonObject2 请求参数: JSONObject
     * @return Jresponse 对象
     */
    Jresponse post(@NotNull String sUrl, JSONObject jsonObject1, JSONObject jsonObject2);

    /**
     * 多参数的POST请求
     *
     * @param objects 所有参数
     * @return Jresponse 对象
     */
    Jresponse post(@NotNull Object... objects);

}
