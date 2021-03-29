package hu.jspider.jrequests.util;

import java.util.Locale;
import java.util.Set;

/**
 * ×Ö·û´®¹¤¾ßÀà
 *
 * @author Hu.Sir
 */
public class StringUtil {
    public static boolean isExistIgnoreCase(Set<String> headers, String str) {
        String ob = str.toUpperCase(Locale.ROOT);
        for (String k : headers) {
            if (k.toUpperCase(Locale.ROOT).equals(ob)) {
                return true;
            }
        }
        return false;
    }
}
