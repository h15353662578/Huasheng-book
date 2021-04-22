package com.hs.bookstock;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Huasheng
 * @Date 2021/04/19/11:54
 * @Description
 */
@EnableDubbo
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BookStock8500 {
    public static void main(String[] args) {
        SpringApplication.run(BookStock8500.class,args);
    }
}
