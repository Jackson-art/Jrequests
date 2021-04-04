package hu.jspider.jrequests.util;

import java.util.Locale;
import java.util.Set;

/**
 * 字符串工具类
 *
 * @author Jackson-art
 */
public class StringUtil {
    /**
     * 键是否存在 - 忽略大小写
     *
     * @param set 键映射
     * @param key 键
     * @return -- 存在 ：true
     * -- 不存在 ： false
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
