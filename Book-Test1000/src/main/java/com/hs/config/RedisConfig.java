package com.hs.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author Huasheng
 * @Date 2021/04/28/15:41
 * @Description
 */
@Configuration
public class RedisConfig {
    @Value("${spring.redis.host}")
    private String host;

    @Bean(name = {"redisTemplate", "stringRedisTemplate"})
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }

    @Bean
    public Redisson redisson() {
        Config config = new Config();
        config.useClusterServers().addNodeAddress("redis://192.168.195.129:6379",
                "redis://192.168.195.129:6378","redis://192.168.195.129:6377","redis://192.168.195.129:6376",
                "redis://192.168.195.129:6375","redis://192.168.195.129:6377").setPassword("000000").setScanInterval(5000);
        return (Redisson) Redisson.create(config);
    }

}