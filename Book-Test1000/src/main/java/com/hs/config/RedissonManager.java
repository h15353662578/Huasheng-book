package com.hs.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.context.annotation.Configuration;


/**
 * @author Huasheng
 * @Date 2021/04/28/10:59
 * @Description
 */
@Configuration
public class RedissonManager {
    private static Config config = new Config();
    //声明redisso对象
    private static Redisson redisson = null;
    //实例化redisson
    static{
        config.useClusterServers().addNodeAddress("redis://192.168.195.129:6379",
                "redis://192.168.195.129:6378","redis://192.168.195.129:6377","redis://192.168.195.129:6376",
                "redis://192.168.195.129:6375","redis://192.168.195.129:6377").setPassword("000000").setScanInterval(5000);
        //得到redisson对象
        redisson = (Redisson) Redisson.create(config);

    }

    //获取redisson对象的方法
    public static Redisson getRedisson(){
        return redisson;
    }
}