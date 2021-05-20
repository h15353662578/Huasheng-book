package com.hs.config;

import java.util.Random;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


/**
 * @author Huasheng
 * @Date 2021/05/11/19:45
 * @Description
 */
public class DDDemo {
    public static String getRandomChineseString(int n) {
        String zh_cn = "";
        String str = "";

        // Unicode中汉字所占区域\u4e00-\u9fa5,将4e00和9fa5转为10进制
        int start = Integer.parseInt("4e00", 16);
        int end = Integer.parseInt("9fa5", 16);

        for (int ic = 0; ic < n; ic++) {
            // 随机值
            int code = (new Random()).nextInt(end - start + 1) + start;
            // 转字符
            str = new String(new char[]{(char) code});
            zh_cn = zh_cn + str;
        }
        return zh_cn;
    }

    public static void main(String[] args) {
        try {
            String url = "http://lx-swtec.com/contact/dobm.html";

            Random random = new Random();
            int a = random.nextInt(585858997);
            String as = "13" + a;
            String mobile = as;
            String name = getRandomChineseString(5);
            String zhuanye = "大数据";
            URIBuilder uriBuilder = new URIBuilder(url);
            List<NameValuePair> list = new LinkedList<>();
            BasicNameValuePair param1 = new BasicNameValuePair("name", name);
            BasicNameValuePair param2 = new BasicNameValuePair("zhuanye", zhuanye);
            BasicNameValuePair param3 = new BasicNameValuePair("mobile", mobile);
            list.add(param1);
            list.add(param2);
            list.add(param3);
            uriBuilder.setParameters(list);
            for (int i = 0; i < 1000; i++) {
                HttpPost httpPost = new HttpPost(uriBuilder.build());
                HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
                CloseableHttpClient client = httpClientBuilder.build();
                CloseableHttpResponse response = null;
                response = client.execute(httpPost);
                StatusLine status = response.getStatusLine();
                int state = status.getStatusCode();
                if (state == HttpStatus.SC_OK) {
                    System.out.println("ok");
                }
                if (response != null) {
                    try {
                        response.close();
                    } catch (IOException e) {
                    }
                }
                try {
                    client.close();
                } catch (IOException e) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
