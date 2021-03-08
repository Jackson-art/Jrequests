# Jrequests - java������requests

## ��飺

��д�����Ŀ֮ǰ�����Ѿ���Python��������һЩ�˽⣬Ҳд��һЩ���ͣ�[https://blog.csdn.net/qq_44700693](https://blog.csdn.net/qq_44700693) �� <br>
������ʹ��java��дһЩweb��Ŀʱ�����õ�һЩ�����ϵ�ʵʱ��Ϣ�����Ծ��������С��Ŀ��Ŀ��������javaԭ����Ļ����Ͻ��з�װ��д��һ��java�˵��� **requests** �����

## ���¼�¼��

| ���� | ����ժҪ |
|---|---|
|**21-3-8**| ���������� **GET** �� **POST** ���󣬲��ύ��Ŀ���ֿ⡣|

## ��Ŀ������

* **log4j-1.2.17** : ������־�����
* **fastjson-1.2.75** : ����JSON���ݲ�����

## ʹ�ý��ܣ�

��Ҫ�������õ�jar����������������Դ����롣

* 1��������Ҫ����һ�� **Jresponse** ����<br>
  `Jresponse jresponse = new Jresponse();`<br>
* 2��ͨ����ͬ������ʽ��������ҳ���� �磺<br>
a������ҳ **url** ���� **GET** ����<br>
`jreponse = jrequests.get(url);`<br>
b������ҳ **url** ���� **POST** ����<br>
`jreponse = jrequests.post(url, json);`
  
>����ֱ���� **Jresponse** ������գ�<br>
`Jresponse jresponse = Jrequests.get(String sUrl);`<br>
`Jresponse jresponse = Jrequests.post(String sUrl);`

## ���ܽ��ܣ�

Ŀǰ�Ѿ�֧�ֵĹ����У�

* 1�� **`getText()`** : ��ȡ��ҳԴ��
* 2�� **`getStatusCode()`** : ��ȡ��ҳ����״̬
* 2�� **`getURL()`** : ��ȡ��ҳ��������

## ����ʾ����

```java
import com.jrequests.entity.Jrequests;
import com.jrequests.entity.Jresponse;

/**
 * ����GET����
 * @author Jackson-art
 */
public class JrequestsDemo1 {
    public static void main(String[] args) {
        // GET
        Jresponse jresponse = Jrequests.get("http://******.com");
        // ��ȡ��ҳԴ��
        System.out.println(jresponse.getText());
        // ��ȡ����״̬��
        System.out.println(jresponse.getStatusCode());
        // ��ȡ����URL
        System.out.println(jresponse.getUrl());
    }
}
```

```java
import com.alibaba.fastjson.JSONObject;
import com.jrequests.entity.Jrequests;
import com.jrequests.entity.Jresponse;

/**
 * ����POST���� 
 * @author Jackson-art
 */
public class JrequestsDemo2 {
    public static void main(String[] args) {
        // POST --- ��������
        Jresponse jresponse = Jrequests.post("https://api.******.php");
        // ��ȡ��ҳԴ��
        System.out.println(jresponse.getText());
        // ��ȡ����״̬��
        System.out.println(jresponse.getStatusCode());
        // ��ȡ����URL
        System.out.println(jresponse.getUrl());

        // POST --- ��������
        JSONObject json = JSONObject.parseObject("{\"key\":\"value\"}");
        Jresponse jresponse = Jrequests.post("https://api.******.php", json);
        // ��ȡ��ҳԴ��
        System.out.println(jresponse.getText());
        // ��ȡ����״̬��
        System.out.println(jresponse.getStatusCode());
        // ��ȡ����URL
        System.out.println(jresponse.getUrl());
    }
}
```