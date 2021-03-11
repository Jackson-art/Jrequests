package com.jrequests.service.method;

import com.alibaba.fastjson.JSONObject;
import com.jrequests.entity.Jresponse;
import com.jrequests.entity.model.JresponseModel;
import com.jrequests.util.JrequestsUtil;

import java.net.HttpURLConnection;

/**
 * GET ����
 *
 * @author Hu.Sir
 */
public class GetMethod {
    public Jresponse getJresponseObject(String sUrl, JSONObject params) {
        // ������ƴ�ӵ���������
        String realUrl;
        if (params != null) {
            realUrl = JrequestsUtil.getRealUrl(sUrl, params);
        } else {
            realUrl = sUrl;
        }

        // ��ȡһ������
        HttpURLConnection httpUrlConnection = Request.getConnection(realUrl);

        // ��ȡ���������
        Jresponse jresponse = JresponseModel.getJresponse(httpUrlConnection);
        httpUrlConnection.disconnect();
        return jresponse;
    }

}
