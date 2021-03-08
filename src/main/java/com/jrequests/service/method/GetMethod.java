package com.jrequests.service.method;

import com.jrequests.entity.Jresponse;
import com.jrequests.entity.model.JresponseModel;

import java.net.HttpURLConnection;

/**
 * GET ����
 *
 * @author Hu.Sir
 */
public class GetMethod {
    public Jresponse getJresponseObject(String sUrl) {
        // ��ȡһ������
        HttpURLConnection httpUrlConnection = Request.getConnection(sUrl);
        // ��ȡ���������
        Jresponse jresponse = JresponseModel.getJresponse(httpUrlConnection);
        httpUrlConnection.disconnect();
        return jresponse;
    }
}
