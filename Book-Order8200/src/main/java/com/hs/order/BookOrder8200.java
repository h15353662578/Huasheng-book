package com.hs.order;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Huasheng
 * @Date 2021/04/12/17:32
 * @Description
 */
@EnableDubbo
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BookOrder8200 {
    public static void main(String[] args) {
        SpringApplication.run(BookOrder8200.class,args);
    }
}
