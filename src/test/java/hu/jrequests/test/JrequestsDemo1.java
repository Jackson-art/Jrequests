package hu.jrequests.test;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jrequests.Jrequests;
import hu.jspider.jrequests.Jresponse;


/**
 * 发送GET请求
 *
 * @author Hu.Sir
 */
public class JrequestsDemo1 {
    public static void main(String[] args) {
        Jrequests jrequests = new Jrequests();
        // Get 不带参数
        Jresponse jresponse = jrequests.get("http://******.com");
        // 获取响应头部
        JSONObject headers = jresponse.getResponseHeaders();
        String set_cookies = headers.getString("Set-Cookie");
        System.out.println(set_cookies);
        // 获取网页源码
        System.out.println(jresponse.getText());
        // 获取请求状态码
        System.out.println(jresponse.getStatusCode());
        // 获取请求URL
        System.out.println(jresponse.getUrl());

        // Get 带参数
        JSONObject params = JSONObject.parseObject("{\"wd\":\"Jrequests site:gitee.com\"}");
        Jresponse jresponse1 = jrequests.get("http://www.baidu.com/s", params);
        System.out.println(jresponse1);
        // 获取响应头部
        JSONObject headers1 = jresponse.getResponseHeaders();
        System.out.println(headers1);
        // 获取网页源码
        System.out.println(jresponse.getText());
        // 获取请求状态码
        System.out.println(jresponse.getStatusCode());
        // 获取请求URL
        System.out.println(jresponse.getUrl());
    }
}