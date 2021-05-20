package com.hs.config;

import com.hs.service.AliService;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Huasheng
 * @Date 2021/05/19/15:11
 * @Description
 */
@Component
public class NetBase64Utils {

    @Resource
    private AliService aliService;

    public String imgNetBase64(String imgURL){
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        try {
            URL url = new URL(imgURL);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10*1000);
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK){
                return "false";
            }
            InputStream inputStream = connection.getInputStream();
            int len = -1;
            while((len = inputStream.read(data)) != -1){
                arrayOutputStream.write(data,0,len);
            }
            inputStream.close();
        }catch(IOException exception){
            exception.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(arrayOutputStream.toByteArray());
    }

    public  String dsb(String url) throws IOException {
        String x = url;
        String y = imgNetBase64(x);
//        System.out.println(imgNetBase64(""+x));
//        System.out.println(imgNetBase64("https://z3.ax1x.com/2021/05/19/g4xvzF.jpg"));
        String ali = aliService.ali(y);
        return ali;

    }
}
