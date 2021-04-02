package hu.jspider.jrequests;

import com.sun.istack.internal.NotNull;
import hu.jspider.jlogger.JLogger;
import hu.jspider.jrequests.impl.Jresponse;
import hu.jspider.jrequests.impl.Requests;
import hu.jspider.jrequests.service.RequestsService;
import hu.jspider.jrequests.util.JrequestsUtil;

/**
 * Jrequests实体类
 *
 * @author Hu.Sir
 */
public class Jrequests extends Requests {
    private static final JLogger LOGGER = JLogger.getLogger();

    public Jrequests() {
    }

    /**
     * Jrequests 构造函数
     *
     * @param encode 指定网页源码的编码格式
     */
    public Jrequests(String encode) {
        super(encode);
    }

    /**
     * 带一个参数的GET请求
     *
     * @param sUrl 请求URL: String
     * @param str  请求参数：String
     * @return Jresponse 对象
     */
    public Jresponse get(@NotNull String sUrl, String str) {
        return new RequestsService().sendRequestByGet(sUrl, JrequestsUtil.getJsonObject(str));
    }

    /**
     * 带两个参数的GET请求
     *
     * @param sUrl 请求URL: String
     * @param str1 请求参数：String
     * @param str2 请求参数：String
     * @return Jresponse 对象
     */
    public Jresponse get(@NotNull String sUrl, String str1, String str2) {
        return new RequestsService().sendRequestByGet(sUrl, JrequestsUtil.getJsonObject(str1), JrequestsUtil.getJsonObject(str2));
    }


    /*===========================================    分 界 线    ===========================================*/

    /**
     * 带一个参数的POST请求
     *
     * @param sUrl 请求URL: String
     * @param str  请求参数: String
     * @return Jresponse 对象
     */
    public Jresponse post(@NotNull String sUrl, String str) {
        return new RequestsService().sendRequestByPost(sUrl, JrequestsUtil.getJsonObject(str));
    }

    /**
     * 带两个参数的POST请求
     *
     * @param sUrl 请求URL: String
     * @param str1 请求参数：String
     * @param str2 请求参数：String
     * @return Jresponse 对象
     */
    public Jresponse post(@NotNull String sUrl, String str1, String str2) {
        return new RequestsService().sendRequestByPost(sUrl, JrequestsUtil.getJsonObject(str1), JrequestsUtil.getJsonObject(str2));
    }

}
