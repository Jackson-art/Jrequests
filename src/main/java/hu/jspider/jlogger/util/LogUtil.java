package hu.jspider.jlogger.util;

import java.io.Closeable;

/**
 * JLogger 工具类
 *
 * @author Hu.Sir
 */
public class LogUtil {

    /**
     * 检查字符长度
     *
     * @param text      被检查的字符串
     * @param maxLength 最大长度
     * @return 修改后的字符串
     */
    public static String checkTextLength(String text, int maxLength) {
        if ((text != null) && (text.length() > maxLength)) {
            text = text.substring(0, maxLength - 3) + "...";
        }
        return text;
    }

    /**
     * 关闭流
     *
     * @param stream 可以关闭的数据源或目标
     */
    public static void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static StackTraceElement getCodeInfo(int flag) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return stackTrace[flag];
    }
}
