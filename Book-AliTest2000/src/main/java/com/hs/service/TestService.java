package com.hs.service;

import com.hs.AliTest2000;
import com.hs.config.NetBase64Utils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author Huasheng
 * @Date 2021/05/19/15:35
 * @Description
 */

@RestController
public class TestService {

    @Resource
    private NetBase64Utils netBase64Utils;

    @GetMapping("/test")
    public String test(String url) throws IOException {
        String dsb = netBase64Utils.dsb(url);
        return dsb;
    }
}
