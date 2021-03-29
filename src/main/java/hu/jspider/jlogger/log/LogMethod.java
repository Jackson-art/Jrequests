package hu.jspider.jlogger.log;

import hu.jspider.jlogger.output.LogOutPutToFile;
import hu.jspider.jlogger.output.LogPrintToConsole;
import hu.jspider.jlogger.util.ReadLogConfigFile;


/**
 * @author Hu.Sir
 */
public class LogMethod {

    /**
     * 打印日志，打印等级为 info,debug,warn
     *
     * @param level        日志等级
     * @param printTag     日志标记
     * @param printMessage 日志信息
     */
    public static void printLog(LogLevel level, String printTag, String printMessage) {
        if (level.getLevelValue() >= ReadLogConfigFile.LOWEST_PRINT_LEVEL) {
            if (ReadLogConfigFile.LOGGER_OUT_CONSOLE) {
                LogPrintToConsole.printToTheConsole(level, printTag, printMessage);
            }
            if (ReadLogConfigFile.LOGGER_OUT_FILE) {
                LogOutPutToFile.printToTheFile(level, printTag, printMessage, true);
            }
        }
    }

    /**
     * 打印日志，打印等级为 error
     *
     * @param level        日志等级
     * @param printTag     日志标记
     * @param printMessage 日志信息
     */
    public static void printError(LogLevel level, String printTag, String printMessage, boolean flag) {
        if (level.getLevelValue() >= ReadLogConfigFile.LOWEST_PRINT_LEVEL) {
            if (ReadLogConfigFile.LOGGER_OUT_CONSOLE) {
                LogPrintToConsole.printErrorToConsole(level, printTag, printMessage, flag);
            }
            if (ReadLogConfigFile.LOGGER_OUT_FILE) {
                LogOutPutToFile.printToTheFile(level, printTag, printMessage, flag);
            }
        }
    }

}
