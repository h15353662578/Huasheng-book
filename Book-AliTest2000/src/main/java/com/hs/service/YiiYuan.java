package com.hs.service;

import com.alibaba.fastjson.JSONObject;
import com.hs.config.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Huasheng
 * @Date 2021/05/20/9:56
 * @Description
 */

@Service
public class YiiYuan {
    public void weather(String area) {
        String host = "https://ali-weather.showapi.com";
        String path = "/area-to-weather";
        String method = "GET";
        String appcode = "fb84c085ae724c6dbf7dc86cc2e78587";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("area", area);
        JSONObject jsonObject = null;
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            jsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
            JSONObject object=jsonObject.getJSONObject("showapi_res_body");
            JSONObject now = object.getJSONObject("now");
            JSONObject aqiDetail = now.getJSONObject("aqiDetail");
            String areas = aqiDetail.getString("area");
            String quality = aqiDetail.getString("quality");
            String pm2 = aqiDetail.getString("pm2_5");
            String temperature = now.getString("temperature");
            String temperature_time = now.getString("temperature_time");
            String weather = now.getString("weather");
            String rain = now.getString("rain");
            String wind_power = now.getString("wind_power");
            System.out.println("城市: "+areas+"\n"+"空气状况: "+quality+"\n"+"pm2.5: "+pm2+"\n"+"温度: "+temperature+"℃"+"\n"+
                    "风力: "+wind_power+"\n"+"降雨概率: "+rain+"\n"+"天气: "+weather+"\n"+"更新日期: "+temperature_time);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


