package com.hs.service;

import com.hs.AliTest2000;
import com.hs.config.NetBase64Utils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * @author Huasheng
 * @Date 2021/05/19/15:35
 * @Description
 */

@RestController
public class TestService {

    @Resource
    private NetBase64Utils netBase64Utils;

    @Resource
    private JuMeiService juMeiService;

    @Resource
    private WangShangService wangShangService;

    @Resource
    private YiiYuan yiiYuan;

    /***
     * 身份证图片上传
     * @param url
     * @return
     * @throws IOException
     */
    @GetMapping("/test")
    public String test(String url) throws IOException {
        String dsb = netBase64Utils.dsb(url);
        return dsb;
    }

    /***
     * 身份证信息校验
     * @param idCardNo
     * @param name
     */
    @PostMapping("/test2")
    public void sfz(@RequestParam String idCardNo,@RequestParam String name) {
        juMeiService.sfz(idCardNo,name);
    }

    /***
     * IP地址查询
     * @param ip
     */
    @GetMapping("/test3")
    public void findIp(String ip){
        wangShangService.findIp(ip);
    }

    /***
     * 查询天气
     * @param area
     */
    @GetMapping("/test4")
    public void weather(String area){
        yiiYuan.weather(area);
    }
}
