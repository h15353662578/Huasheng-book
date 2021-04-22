package com.hs.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author Huasheng
 * @Date 2021/04/12/17:32
 * @Description
 */

@CrossOrigin
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Gateway5000 {
    public static void main(String[] args) {
        SpringApplication.run(Gateway5000.class,args);
    }
}
