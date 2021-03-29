package hu.jspider.jlogger.output;

import hu.jspider.jlogger.log.LogLevel;
import hu.jspider.jlogger.util.LogUtil;
import hu.jspider.jlogger.util.ReadLogConfigFile;

import java.util.Date;

/**
 * 打印日志到控制台
 *
 * @author Hu.Sir
 */
public class LogPrintToConsole {
    /**
     * 打印日志到控制台，打印等级：info,debug,warn
     *
     * @param level        日志等级
     * @param printTag     日志标记
     * @param printMessage 日志信息
     */
    public static void printToTheConsole(LogLevel level, String printTag, String printMessage) {
        int specialMarkLevel = 3;
        if (level.getLevelValue() >= specialMarkLevel) {

            System.err.printf(ReadLogConfigFile.OUT_FORMAT + "\n", level.getLevelTag(),
                    ReadLogConfigFile.DATE_FORMAT.format(new Date()),
                    LogUtil.getCodeInfo(5),
                    LogUtil.checkTextLength(printTag, ReadLogConfigFile.TAG_MAX_LENGTH),
                    LogUtil.checkTextLength(printMessage, ReadLogConfigFile.MESSAGE_MAX_LENGTH)
            );
        } else {
            System.out.printf(ReadLogConfigFile.OUT_FORMAT + "\n", level.getLevelTag(),
                    ReadLogConfigFile.DATE_FORMAT.format(new Date()),
                    LogUtil.getCodeInfo(5),
                    LogUtil.checkTextLength(printTag, ReadLogConfigFile.TAG_MAX_LENGTH),
                    LogUtil.checkTextLength(printMessage, ReadLogConfigFile.MESSAGE_MAX_LENGTH)
            );
        }
    }

    /**
     * 打印日志到控制台，打印等级：error
     *
     * @param level        日志等级
     * @param printTag     日志标记
     * @param printMessage 日志信息
     * @param flag         报错信息
     */
    public static void printErrorToConsole(LogLevel level, String printTag, String printMessage, boolean flag) {
        String codeInfo = "";
        if (flag) {
            codeInfo = String.valueOf(LogUtil.getCodeInfo(5));
        }
        System.err.printf(ReadLogConfigFile.OUT_FORMAT + "\n", level.getLevelTag(),
                ReadLogConfigFile.DATE_FORMAT.format(new Date()),
                codeInfo,
                LogUtil.checkTextLength(printTag, ReadLogConfigFile.TAG_MAX_LENGTH),
                LogUtil.checkTextLength(printMessage, ReadLogConfigFile.MESSAGE_MAX_LENGTH)
        );
    }
}
