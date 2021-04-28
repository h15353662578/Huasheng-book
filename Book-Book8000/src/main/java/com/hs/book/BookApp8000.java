package com.hs.book;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Huasheng
 * @Date 2021/04/12/17:28
 * @Description
 */

@EnableDubbo
@MapperScan("com.hs.book.mapper")
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BookApp8000 {

    public static void main(String[] args) {
        SpringApplication.run(BookApp8000.class,args);
    }
}
