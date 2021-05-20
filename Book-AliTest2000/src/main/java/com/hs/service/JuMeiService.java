package com.hs.service;

import com.hs.config.HttpUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Huasheng
 * @Date 2021/05/20/8:40
 * @Description
 */
@Service
public class JuMeiService {
    public void sfz(String idCardNo, String name) {
        String host = "https://jmidcardv1.market.alicloudapi.com";
        String path = "/idcard/validate";
        String method = "POST";
        String appcode = "fb84c085ae724c6dbf7dc86cc2e78587";
        Map<String, String> headers = new HashMap<String, String>();
        //header中的格式为Authorization:APPCODE fb84c085ae724c6dbf7dc86cc2e78587
        headers.put("Authorization", "APPCODE " + appcode);
        //定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("idCardNo", idCardNo);
        querys.put("name", name);
        String bodys = "{\"idCardNo\":\""+idCardNo+"\",\"name\":\""+name+"\"}";

        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response);
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity(),"UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

