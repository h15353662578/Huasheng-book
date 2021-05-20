package com.hs.config;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Huasheng
 * @Date 2021/05/19/14:34
 * @Description
 */
public class Base64Utils {
    public static String imageToBase64(String path) {
        byte[] data = null;
        try {
            InputStream in = new FileInputStream(path);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        System.out.println("-----------------"+data);
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }

    public static void main(String[] args) {
        System.out.println("+++++++"+imageToBase64("C:\\Users\\Huasheng\\Desktop\\1621395623405.jpg"));
    }
}
