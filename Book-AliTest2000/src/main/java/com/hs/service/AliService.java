package com.hs.service;

import com.hs.config.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Huasheng
 * @Date 2021/05/19/15:39
 * @Description
 */

@Service
public class AliService {
    public String ali(String y) throws IOException {
        String host = "https://cardpack.market.alicloudapi.com";
        String path = "/rest/160601/ocr/ocr_idcard.json";
        String method = "POST";
        String appcode = "fb84c085ae724c6dbf7dc86cc2e78587";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        String bodys = "{\"image\":\"data:image/jpeg;base64,"+y+"\",\"configure\":{\"side\":\"face\"}}";
        String rt = null;
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
//            System.out.println(response.toString());
            rt = response.toString();
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
//            System.out.println(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }
}
