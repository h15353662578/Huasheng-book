package com.hs.customerAccount;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Huasheng
 * @Date 2021/04/16/8:55
 * @Description
 */

@EnableDubbo
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CustomerAccount8300 {
    public static void main(String[] args) {
        SpringApplication.run(CustomerAccount8300.class,args);
    }
}
