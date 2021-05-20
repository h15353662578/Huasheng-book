package com.hs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Huasheng
 * @Date 2021/04/21/17:31
 * @Description
 */
@EnableFeignClients
@SpringBootApplication
//@EnableDiscoveryClient
public class Test1000 {
    public static void main(String[] args) {
        SpringApplication.run(Test1000.class,args);
    }
}
