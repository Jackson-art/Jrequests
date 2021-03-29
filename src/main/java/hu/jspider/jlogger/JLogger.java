package hu.jspider.jlogger;

import hu.jspider.jlogger.log.LogLevel;
import hu.jspider.jlogger.log.LogMethod;
import hu.jspider.jlogger.util.LogUtil;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * JLogger 类
 *
 * @author Hu.Sir
 */
public class JLogger {
    /**
     * 消息等级：INFO
     *
     * @param printTag     日志信息标记
     * @param printMessage 日志信息
     */
    public void info(String printTag, String printMessage) {
        LogMethod.printLog(LogLevel.INFO, printTag, printMessage);
    }

    /**
     * 消息等级：DEBUG
     *
     * @param printTag     日志信息标记
     * @param printMessage 日志信息
     */
    public void debug(String printTag, String printMessage) {
        LogMethod.printLog(LogLevel.DEBUG, printTag, printMessage);
    }

    /**
     * 消息等级：WARN
     *
     * @param printTag     日志信息标记
     * @param printMessage 日志信息
     */
    public void warn(String printTag, String printMessage) {
        LogMethod.printLog(LogLevel.WARN, printTag, printMessage);
    }

    /**
     * 消息等级：ERROR
     *
     * @param printTag     日志信息标记
     * @param printMessage 日志信息
     */
    public void error(String printTag, String printMessage) {
        LogMethod.printError(LogLevel.ERROR, printTag, printMessage, true);
    }

    /**
     * 消息等级：ERROR
     *
     * @param printTag 日志信息标记
     * @param e        捕获的异常信息
     */
    public void error(String printTag, Exception e) {
        if (e == null) {
            error(printTag, (String) null);
            return;
        }
        PrintStream printOut = null;
        try {
            ByteArrayOutputStream bytesBufOut = new ByteArrayOutputStream();
            printOut = new PrintStream(bytesBufOut);
            e.printStackTrace(printOut);
            printOut.flush();
            LogMethod.printError(LogLevel.ERROR, printTag, bytesBufOut.toString("UTF-8"), false);
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            LogUtil.closeStream(printOut);
        }
    }

    /**
     * 获取一个Logger对象
     *
     * @return 一个Logger对象
     */
    public static JLogger getLogger() {
        return new JLogger();
    }

}
