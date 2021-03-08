package com.jrequests.service.method;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 请求实体
 *
 * @author Hu.Sir
 */
public class Request {
    private static final Logger logger = Logger.getLogger(Class.class);

    public static HttpURLConnection getConnection(String sUrl) {
        URL url = null;
        try {
            url = new URL(sUrl);
        } catch (MalformedURLException e) {
            logger.error("错误的URL: 在规范字符串中找不到任何合法协议 / 无法解析字符串。");
        }
        HttpURLConnection httpUrlConnection = null;
        try {
            assert url != null;
            httpUrlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            logger.error("失败或中断的 I/O 操作。");
        }
        return httpUrlConnection;
    }
}
