package hu.jspider.jrequests.impl;

import com.alibaba.fastjson.JSONObject;
import com.sun.istack.internal.NotNull;
import hu.jspider.jrequests.service.RequestsService;

/**
 * 实现RequestsImpl接口
 *
 * @author Hu.Sir
 */
public class Requests implements RequestsImpl {
    /**
     * 网页源码的编码格式 : 默认为 UTF-8
     */
    public static String encode;

    public Requests() {
        Requests.encode = "UTF-8";
    }


    /**
     * Jrequests 构造函数
     *
     * @param encode 指定网页源码的编码格式
     */
    public Requests(String encode) {
        Requests.encode = encode;
    }

    /**
     * 不带参数的GET请求
     *
     * @param sUrl 请求URL: String
     * @return Jresponse 对象
     */
    @Override
    public Jresponse get(@NotNull String sUrl) {
        return new RequestsService().sendRequestByGet(sUrl);
    }

    /**
     * 带一个参数的GET请求
     *
     * @param sUrl       请求URL: String
     * @param jsonObject 请求参数：JSONObject
     * @return Jresponse 对象
     */
    @Override
    public Jresponse get(@NotNull String sUrl, JSONObject jsonObject) {
        return new RequestsService().sendRequestByGet(sUrl, jsonObject);
    }

    /**
     * 带两个参数的GET请求
     *
     * @param sUrl        请求URL: String
     * @param jsonObject1 请求参数：JSONObject
     * @param jsonObject2 请求参数：JSONObject
     * @return Jresponse 对象
     */
    @Override
    public Jresponse get(@NotNull String sUrl, JSONObject jsonObject1, JSONObject jsonObject2) {
        return new RequestsService().sendRequestByGet(sUrl, jsonObject1, jsonObject2);
    }

    /**
     * 多参数同时传递
     *
     * @param objects 所有参数
     * @return Jresponse 对象
     */
    @Override
    public Jresponse get(@NotNull Object... objects) {
        return null;
    }


    /*===========================================    分 界 线    ===========================================*/


    /**
     * 不带参数POST请求
     *
     * @param sUrl 请求URL: String
     * @return Jresponse 对象
     */
    @Override
    public Jresponse post(@NotNull String sUrl) {
        return new RequestsService().sendRequestByPost(sUrl);
    }

    /**
     * 带一个参数的POST请求
     *
     * @param sUrl       请求URL: String
     * @param jsonObject 请求参数: JSONObject
     * @return Jresponse 对象
     */
    @Override
    public Jresponse post(@NotNull String sUrl, JSONObject jsonObject) {
        return new RequestsService().sendRequestByPost(sUrl, jsonObject);
    }

    /**
     * 带两个参数的POST请求
     *
     * @param sUrl        请求URL: String
     * @param jsonObject1 请求参数: JSONObject
     * @param jsonObject2 请求参数: JSONObject
     * @return Jresponse 对象
     */
    @Override
    public Jresponse post(@NotNull String sUrl, JSONObject jsonObject1, JSONObject jsonObject2) {
        return new RequestsService().sendRequestByPost(sUrl, jsonObject1, jsonObject2);
    }

    /**
     * 多参数的POST请求
     *
     * @param objects 所有参数
     * @return Jresponse 对象
     */
    @Override
    public Jresponse post(@NotNull Object... objects) {
        return null;
    }
}
