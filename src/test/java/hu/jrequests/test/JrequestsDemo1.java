package hu.jrequests.test;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jrequests.Jrequests;
import hu.jspider.jrequests.Jresponse;


/**
 * ����GET����
 *
 * @author Hu.Sir
 */
public class JrequestsDemo1 {
    public static void main(String[] args) {
        Jrequests jrequests = new Jrequests();
        // Get ��������
        Jresponse jresponse = jrequests.get("http://******.com");
        // ��ȡ��Ӧͷ��
        JSONObject headers = jresponse.getResponseHeaders();
        String set_cookies = headers.getString("Set-Cookie");
        System.out.println(set_cookies);
        // ��ȡ��ҳԴ��
        System.out.println(jresponse.getText());
        // ��ȡ����״̬��
        System.out.println(jresponse.getStatusCode());
        // ��ȡ����URL
        System.out.println(jresponse.getUrl());

        // Get ������
        JSONObject params = JSONObject.parseObject("{\"wd\":\"Jrequests site:gitee.com\"}");
        Jresponse jresponse1 = jrequests.get("http://www.baidu.com/s", params);
        System.out.println(jresponse1);
        // ��ȡ��Ӧͷ��
        JSONObject headers1 = jresponse.getResponseHeaders();
        System.out.println(headers1);
        // ��ȡ��ҳԴ��
        System.out.println(jresponse.getText());
        // ��ȡ����״̬��
        System.out.println(jresponse.getStatusCode());
        // ��ȡ����URL
        System.out.println(jresponse.getUrl());
    }
}