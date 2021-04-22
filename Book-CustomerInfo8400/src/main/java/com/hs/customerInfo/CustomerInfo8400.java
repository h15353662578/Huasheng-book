package com.hs.customerInfo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Huasheng
 * @Date 2021/04/16/8:57
 * @Description
 */

@EnableFeignClients
@EnableDubbo
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CustomerInfo8400 {
    public static void main(String[] args) {
        SpringApplication.run(CustomerInfo8400.class,args);

    }
}
