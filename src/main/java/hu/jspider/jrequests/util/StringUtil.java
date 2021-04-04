package hu.jspider.jrequests.util;

import java.util.Locale;
import java.util.Set;

/**
 * �ַ���������
 *
 * @author Jackson-art
 */
public class StringUtil {
    /**
     * ���Ƿ���� - ���Դ�Сд
     *
     * @param set ��ӳ��
     * @param key ��
     * @return -- ���� ��true
     * -- ������ �� false
     */
    public static boolean isExistIgnoreCase(Set<String> set, String key) {
        String ob = key.toUpperCase(Locale.ROOT);
        for (String k : set) {
            if (k.toUpperCase(Locale.ROOT).equals(ob)) {
                return true;
            }
        }
        return false;
    }
}
