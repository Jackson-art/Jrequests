package hu.jspider.jlogger.util;


import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

/**
 * 读取配置文件
 *
 * @author Hu.Sir
 */
public class ReadLogConfigFile {

    /**
     * 配置文件读取
     */
    protected static final ResourceBundle RESOURCE = ResourceBundle.getBundle("logger");
    /**
     * 日期前缀格式化
     */
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(RESOURCE.getString("DATE_FORMAT"));

    /**
     * 每条 Log 的 tag 输出的最大长度, 超过部分将被截断
     */
    public static final int TAG_MAX_LENGTH = Integer.parseInt(RESOURCE.getString("TAG_MAX_LENGTH"));

    /**
     * 每条 Log 的 message 输出的最大长度, 超过部分将被截断
     */
    public static final int MESSAGE_MAX_LENGTH = Integer.parseInt(RESOURCE.getString("MESSAGE_MAX_LENGTH"));

    /**
     * 输出格式 :<等级><日期> 代码位置 标志 描述
     */
    public static final String OUT_FORMAT = "<%s><%s> %s %s : %s";

    /**
     * 输出到日志文件
     */
    public static final boolean LOGGER_OUT_FILE = Boolean.parseBoolean(RESOURCE.getString("LOGGER_OUT_FILE"));

    /**
     * 输出文件路径
     */
    public static final String FILE_PATH = RESOURCE.getString("FILE_PATH");


    /**
     * 最低输出日志等级
     */
    public static final int LOWEST_PRINT_LEVEL = Integer.parseInt(RESOURCE.getString("LOWEST_PRINT_LEVEL"));

    /**
     * 输出到控制台
     */
    public static final boolean LOGGER_OUT_CONSOLE = Boolean.parseBoolean(RESOURCE.getString("LOGGER_OUT_CONSOLE"));

}
