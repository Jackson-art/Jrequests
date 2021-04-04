# Jrequests - java端requests

## 简介：

在写这个项目之前本人已经对Python爬虫有了一些了解，也写过一些博客：[https://blog.csdn.net/qq_44700693](https://blog.csdn.net/qq_44700693) 。 <br>
后来在使用java编写一些web项目时，会用到一些网络上的实时信息，所以就有了这个小项目，目的在于在java原生类的基础上进行封装，写出一个java端的类 **requests** 插件。

## 更新记录：

| 日 期 | 更 新 摘 要 |
| ------ | ------ |
| **21-4-2** | 请求参数支持传JSONObject或String。<br>实际上都是调用的参数类型为JSONObject类型的方法，传入String类型时进行了类型转换。|
| **21-3-31** | 重构逻辑，实现对应接口，GET和POST都已经支持单独的请求体、单独的请求头或请求头和请求体一起传入。<br>创建了多参数的方法待用。|
| **21-3-29** | POST支持同时添加请求头和请求体 |
| **21-3-20** | 在实例化`Jrequests`对象时可以指定编码，默认 `UTF-8` |
| **21-3-11** | 新增响应头部信息的获取，返回的是一个 **JSON** 对象。 |
| **21-3-9** | GET请求更新带参数请求方式。中文自动编码。 |
| **21-3-8** | 完成最基本的 **GET** 和 **POST** 请求，并提交项目至仓库。|

## 项目依赖：

* **JLogger** : 自己编写的极简日志工具，用于日志输出。
  > 仓库地址：[https://gitee.com/jackson-art/jlogger](https://gitee.com/jackson-art/jlogger)
* **fastjson-1.2.75** : 用于JSON数据操作。

## 方法定义：

> 不带参数：**`get(String sUrl)`** <br>

> 一个参数：**`get(String sUrl, JSONObject jsonObject)`**<br>
>> 同时接受 **headers** 或 **data** 或 **params** 。有判断去分别处理。<br>

> 带两个参数：**`get(String sUrl, JSONObject jsonObject, JSONObject jsonObject)`**
>> 参数不分先后，（headers, params/data）

> **POST** 请求类似

## 使用介绍：

需要导入编译好的jar包，或者自行下载源码编译。

* 1、首先需要创建 **Jrequests** 对象：<br>
  `Jrequests jrequests = new Jrequests();`<br>
* 2、通过不同的请求方式来进行网页请求： 如：<br>
  a、对网页 **url** 进行 **GET** 请求：<br>
  `Jresponse jreponse = jrequests.get(String url);`<br>
  b、对网页 **url** 进行 **POST** 请求：<br>
  `Jresponse jreponse = jrequests.post(String url,String data);`

## 功能介绍：

目前已经支持的功能有：

| 方法 | 作用 | 
| --- | --- |
| **`getURL()`** | 获取网页请求链接|
| **`getText()`** | 获取网页源码 |
| **`getJson()`** | 获取返回的JSON数据 |
| **`getStatusCode()`** | 获取网页请求状态 |
| **`getRequestsHeaders()`** | 获取请求头部信息 |
| **`getResponseHeaders()`** | 获取响应头部信息 |

## 代码示例：

```java
import com.alibaba.fastjson.JSONObject;
import hu.jspider.jrequests.Jrequests;
import hu.jspider.jrequests.Jresponse;
import hu.jspider.jrequests.impl.Response;


/**
 * 发送GET请求
 * @author Jackson-art
 */
public class JrequestsDemo1 {
    public static void main(String[] args) {
        Jrequests jrequests = new Jrequests();
        // Get 不带参数
        Jresponse jresponse = jrequests.get("http://******.com");
        // 获取响应头部
        JSONObject headers = jresponse.getResponseHeaders();
        String set_cookies = headers.getString("Set-Cookie");
        System.out.println(set_cookies);
        // 获取网页源码
        System.out.println(jresponse.getText());
        // 获取请求状态码
        System.out.println(jresponse.getStatusCode());
        // 获取请求URL
        System.out.println(jresponse.getUrl());

        // Get 带参数
        JSONObject params = JSONObject.parseObject("{\"wd\":\"Jrequests site:gitee.com\"}");
        Jresponse jresponse = jrequests.get("http://www.baidu.com/s", params);
        // 获取响应头部
        JSONObject headers = jresponse.getResponseHeaders();
        // 获取网页源码
        System.out.println(jresponse.getText());
        // 获取请求状态码
        System.out.println(jresponse.getStatusCode());
        // 获取请求URL
        System.out.println(jresponse.getUrl());
    }
}
```

```java
import com.alibaba.fastjson.JSONObject;
import hu.jspider.jrequests.Jrequests;
import hu.jspider.jrequests.Jresponse;


/**
 * 发送POST请求 
 * @author Jackson-art
 */
public class JrequestsDemo2 {
    public static void main(String[] args) {
        Jrequests jrequests = new Jrequests("utf-8");
        // Post --- 无请求体
        Jresponse jresponse = jrequests.post("https://api.******.php");
        // 获取响应头部
        JSONObject headers = jresponse.getResponseHeaders();
        // 获取网页源码
        System.out.println(jresponse.getText());
        // 获取请求状态码
        System.out.println(jresponse.getStatusCode());
        // 获取请求URL
        System.out.println(jresponse.getUrl());

        // Post --- 有请求体
        JSONObject json = JSONObject.parseObject("{\"key\":\"value\"}");
        Jresponse jresponse = jrequests.post("https://api.******.php", json);
        // 获取响应头部
        JSONObject headers = jresponse.getResponseHeaders();

        // 获取网页源码
        System.out.println(jresponse.getText());
        // 获取请求状态码
        System.out.println(jresponse.getStatusCode());
        // 获取请求URL
        System.out.println(jresponse.getUrl());
    }
}
```