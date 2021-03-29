package hu.jspider.jlogger.output;

import hu.jspider.jlogger.log.LogLevel;
import hu.jspider.jlogger.util.LogUtil;
import hu.jspider.jlogger.util.ReadLogConfigFile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * 日志输出到文件
 *
 * @author Hu.Sir
 */
public class LogOutPutToFile {


    /**
     * 日志文件输出流, 追加到文件尾
     */
    private static RandomAccessFile logOutFileStream;

    /**
     * 输出日志到文件
     *
     * @param logOutFile 目标文件
     * @param message    日志信息
     */
    public static synchronized void outPutToFile(File logOutFile, String message) {

        if (logOutFileStream != null) {
            LogUtil.closeStream(logOutFileStream);
            logOutFileStream = null;
        }

        if (logOutFile != null) {
            try {
                logOutFileStream = new RandomAccessFile(logOutFile, "rw");
                logOutFileStream.seek(logOutFile.length());
            } catch (IOException e) {
                LogUtil.closeStream(logOutFileStream);
                logOutFileStream = null;
            }
        }

        if (logOutFileStream != null) {
            try {
                logOutFileStream.write((message + "\n").getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 输出日志到文件
     *
     * @param level        日志等级
     * @param printTag     日志标记
     * @param printMessage 日志信息
     * @param flag         输出报错信息
     */
    public static void printToTheFile(LogLevel level, String printTag, String printMessage, boolean flag) {
        String codeInfo = "";
        if (flag) {
            codeInfo = String.valueOf(LogUtil.getCodeInfo(5));
        }
        String outStr = String.format(ReadLogConfigFile.OUT_FORMAT, level.getLevelTag(),
                ReadLogConfigFile.DATE_FORMAT.format(new Date()),
                codeInfo,
                LogUtil.checkTextLength(printTag, ReadLogConfigFile.TAG_MAX_LENGTH),
                LogUtil.checkTextLength(printMessage, ReadLogConfigFile.MESSAGE_MAX_LENGTH)
        );
        try {
            File file = new File(new File("").getCanonicalPath() + ReadLogConfigFile.FILE_PATH);
            outPutToFile(file, outStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
