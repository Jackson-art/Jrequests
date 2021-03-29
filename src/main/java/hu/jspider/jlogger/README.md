# JLogger --- 极简版日志工具

## 介绍

自己实现的极简版日志工具，主要用于在自己的项目内置。<br>
那些日志框架功能太多，体积太大，不适合我的一些小项目。所以才有了JLogger。<br>
主要代码参考了一些大佬的思路。然后左右一些修改。

## 配置文件说明

| **配置字段参数** | 作用 |
| --- | --- |
| **LOGGER_OUT_FILE** | 是否将日志输出到 **文件** |
| **LOGGER_OUT_CONSOLE** | 是否将日志输出到 **控制台** |
| **TAG_MAX_LENGTH** | 每条 Log 的 tag 输出的最大长度 |
| **MESSAGE_MAX_LENGTH** | 每条 Log 的 message 输出的最大长度 |
| **LOWEST_PRINT_LEVEL** | 日志最低输出级别，等级注释：<br> 1 : DEBUG <br> 2 : INFO<br> 3 : WARN<br> 4 : ERROR|
| **DATE_FORMAT** | 日期格式 |
| **FILE_PATH** | 输出文件路径 |

## 使用示例

### 配置文件：

maven项目：在resources目录下创建一个配置文件：**logger.properties**

```properties
# 输出到文件
LOGGER_OUT_FILE=true
# 输出到控制台
LOGGER_OUT_CONSOLE=true
# 每条 Log 的 tag 输出的最大长度, 超过部分将被截断
TAG_MAX_LENGTH=15
# 每条 Log 的 message 输出的最大长度, 超过部分将被截断
MESSAGE_MAX_LENGTH=200
# 日志最低输出级别
LOWEST_PRINT_LEVEL=1
# 日期格式
DATE_FORMAT=yyyy-MM-dd HH:mm:ss
# 输出文件路径
FILE_PATH=/src/main/resources/logger.log
```

### 代码：

```java
public class LoggerTest {
    // 创建一个JLogger对象
    private static final JLogger logger = JLogger.getJLogger();

    public static void main(String[] args) {
        logger.debug("debug", "debug test...");
        logger.info("info", "info test...");
        logger.warn("warn", "warn test...");
        logger.error("error", "error test...");
        // 手动创建一个异常
        int[] a = new int[5];
        try {
            for (int i = 0; i < 10; i++) {
                a[i] = i;
            }
        } catch (Exception e) {
            logger.error("error", e);
        }
    }
}
```