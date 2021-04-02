package hu.jspider.jrequests;

import com.sun.istack.internal.NotNull;
import hu.jspider.jlogger.JLogger;
import hu.jspider.jrequests.impl.Jresponse;
import hu.jspider.jrequests.impl.Requests;
import hu.jspider.jrequests.service.RequestsService;
import hu.jspider.jrequests.util.JrequestsUtil;

/**
 * Jrequestsʵ����
 *
 * @author Hu.Sir
 */
public class Jrequests extends Requests {
    private static final JLogger LOGGER = JLogger.getLogger();

    public Jrequests() {
    }

    /**
     * Jrequests ���캯��
     *
     * @param encode ָ����ҳԴ��ı����ʽ
     */
    public Jrequests(String encode) {
        super(encode);
    }

    /**
     * ��һ��������GET����
     *
     * @param sUrl ����URL: String
     * @param str  ���������String
     * @return Jresponse ����
     */
    public Jresponse get(@NotNull String sUrl, String str) {
        return new RequestsService().sendRequestByGet(sUrl, JrequestsUtil.getJsonObject(str));
    }

    /**
     * ������������GET����
     *
     * @param sUrl ����URL: String
     * @param str1 ���������String
     * @param str2 ���������String
     * @return Jresponse ����
     */
    public Jresponse get(@NotNull String sUrl, String str1, String str2) {
        return new RequestsService().sendRequestByGet(sUrl, JrequestsUtil.getJsonObject(str1), JrequestsUtil.getJsonObject(str2));
    }


    /*===========================================    �� �� ��    ===========================================*/

    /**
     * ��һ��������POST����
     *
     * @param sUrl ����URL: String
     * @param str  �������: String
     * @return Jresponse ����
     */
    public Jresponse post(@NotNull String sUrl, String str) {
        return new RequestsService().sendRequestByPost(sUrl, JrequestsUtil.getJsonObject(str));
    }

    /**
     * ������������POST����
     *
     * @param sUrl ����URL: String
     * @param str1 ���������String
     * @param str2 ���������String
     * @return Jresponse ����
     */
    public Jresponse post(@NotNull String sUrl, String str1, String str2) {
        return new RequestsService().sendRequestByPost(sUrl, JrequestsUtil.getJsonObject(str1), JrequestsUtil.getJsonObject(str2));
    }

}
