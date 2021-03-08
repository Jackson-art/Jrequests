# Jrequests - java端懒人requests

## 简介：

在写这个项目之前本人已经对Python爬虫有了一些了解，也写过一些博客：[https://blog.csdn.net/qq_44700693](https://blog.csdn.net/qq_44700693) 。 <br>
后来在使用java编写一些web项目时，会用到一些网络上的实时信息，所以就有了这个小项目，目的在于在java原生类的基础上进行封装，写出一个java端的类 **requests** 插件。

## 更新记录：

| 日期 | 更新摘要 |
|---|---|
|**21-3-8**| 完成最基本的 **GET** 和 **POST** 请求，并提交项目至仓库。|

## 项目依赖：

* **log4j-1.2.17** : 用于日志输出。
* **fastjson-1.2.75** : 用于JSON数据操作。

## 使用介绍：

需要导入编译好的jar包，或者自行下载源码编译。

* 1、首先需要创建一个 **Jresponse** 对象：<br>
  `Jresponse jresponse = new Jresponse();`<br>
* 2、通过不同的请求方式来进行网页请求： 如：<br>
a、对网页 **url** 进行 **GET** 请求：<br>
`jreponse = jrequests.get(url);`<br>
b、对网页 **url** 进行 **POST** 请求：<br>
`jreponse = jrequests.post(url, json);`
  
>或者直接用 **Jresponse** 对象接收：<br>
`Jresponse jresponse = Jrequests.get(String sUrl);`<br>
`Jresponse jresponse = Jrequests.post(String sUrl);`

## 功能介绍：

目前已经支持的功能有：

* 1、 **`getText()`** : 获取网页源码
* 2、 **`getStatusCode()`** : 获取网页请求状态
* 2、 **`getURL()`** : 获取网页请求链接

## 代码示例：

```java
import com.jrequests.entity.Jrequests;
import com.jrequests.entity.Jresponse;

/**
 * 发送GET请求
 * @author Jackson-art
 */
public class JrequestsDemo1 {
    public static void main(String[] args) {
        // GET
        Jresponse jresponse = Jrequests.get("http://******.com");
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
import com.jrequests.entity.Jrequests;
import com.jrequests.entity.Jresponse;

/**
 * 发送POST请求 
 * @author Jackson-art
 */
public class JrequestsDemo2 {
    public static void main(String[] args) {
        // POST --- 无请求体
        Jresponse jresponse = Jrequests.post("https://api.******.php");
        // 获取网页源码
        System.out.println(jresponse.getText());
        // 获取请求状态码
        System.out.println(jresponse.getStatusCode());
        // 获取请求URL
        System.out.println(jresponse.getUrl());

        // POST --- 有请求体
        JSONObject json = JSONObject.parseObject("{\"key\":\"value\"}");
        Jresponse jresponse = Jrequests.post("https://api.******.php", json);
        // 获取网页源码
        System.out.println(jresponse.getText());
        // 获取请求状态码
        System.out.println(jresponse.getStatusCode());
        // 获取请求URL
        System.out.println(jresponse.getUrl());
    }
}
```