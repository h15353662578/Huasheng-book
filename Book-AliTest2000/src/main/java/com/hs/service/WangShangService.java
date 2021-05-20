package com.hs.service;


import com.hs.config.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Huasheng
 * @Date 2021/05/20/9:41
 * @Description
 */

@Service
public class WangShangService {
    public void findIp(String ip){
        String host = "https://jisuip.market.alicloudapi.com";
        String path = "/ip/location";
        String method = "GET";
        String appcode = "fb84c085ae724c6dbf7dc86cc2e78587";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("ip", ip);

        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
