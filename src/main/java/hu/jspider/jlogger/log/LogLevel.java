package hu.jspider.jlogger.log;

/**
 * Log 等级枚举
 *
 * @author Hu.Sir
 */
public enum LogLevel {
    /**
     * 等级：DEBUG
     */
    DEBUG("DEBUG", 1),
    /**
     * 等级：INFO
     */
    INFO("INFO", 2),
    /**
     * 等级：WARN
     */
    WARN("WARN", 3),
    /**
     * 等级：ERROR
     */
    ERROR("ERROR", 4);

    private final String levelTag;

    private final int levelValue;

    LogLevel(String levelTag, int levelValue) {
        this.levelTag = levelTag;
        this.levelValue = levelValue;
    }

    public String getLevelTag() {
        return levelTag;
    }

    public int getLevelValue() {
        return levelValue;
    }

}
