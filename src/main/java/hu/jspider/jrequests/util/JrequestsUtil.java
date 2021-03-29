package hu.jspider.jrequests.util;

import com.alibaba.fastjson.JSONObject;
import hu.jspider.jlogger.JLogger;
import hu.jspider.jrequests.entity.Jrequests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 网页源码获取工具
 *
 * @author Hu.Sir
 */
public class JrequestsUtil {
    /**
     * JLogger 日志对象
     */
    private static final JLogger LOGGER = JLogger.getLogger();

    /**
     * 获取拼接网页源码
     *
     * @param httpUrlConnection 请求连接 : HttpURLConnection
     * @return 网页源码 : String
     */
    public static String getText(HttpURLConnection httpUrlConnection) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream(), Jrequests.encode));
        } catch (IOException e) {
            LOGGER.error("获取网页源码", "失败或中断的 I/O 操作。");
        }
        String lines;
        StringBuilder text = new StringBuilder();
        try {
            while (true) {
                assert reader != null;
                if ((lines = reader.readLine()) == null) {
                    break;
                } else {
                    text.append(lines);
                }
            }
        } catch (IOException e) {
            LOGGER.error("拼接网页源码", "获取 text 失败！");
        }
        return text.toString();
    }

    /**
     * 获取拼接参数后的URL
     *
     * @param sUrl   请求的部分URL: String
     * @param params 请求参数: JSONObject
     * @return 拼接后的URL: String
     */
    public static String getRealUrl(String sUrl, JSONObject params) {
        boolean isFirst = true;
        StringBuilder realUrl = new StringBuilder();
        realUrl.append(sUrl).append("?");
        for (String str : params.keySet()) {
            if (isFirst) {
                realUrl.append(str).append("=").append(getUrlEncode(params.getString(str)));
                isFirst = false;
            } else {
                realUrl.append("&").append(str).append("=").append(getUrlEncode(params.getString(str)));
            }
        }
        return realUrl.toString();
    }


    private final static Pattern P = Pattern.compile("[\u4e00-\u9fa5]");

    /**
     * URL链接中的中文进行编码
     *
     * @param str 含中文的字符串：String
     * @return 编码后的字符串
     */
    private static String getUrlEncode(String str) {
        final Matcher m = P.matcher(str);
        String tempStr = str.replaceAll(" ", "%20");
        if (m.find()) {
            String reStr = "";
            try {
                reStr = URLEncoder.encode(tempStr, "GBK");
            } catch (UnsupportedEncodingException e) {
                LOGGER.error("请求参数中文转码", "不支持字符编码!");
            }
            return reStr.trim();
        }
        return tempStr.trim();
    }


}

