package com.hs.config;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.List;

/**
 * @author Huasheng
 * @Date 2021/04/29/14:47
 * @Description
 */
public class BloomTest {
    public static void main(String[] args) {

            Config config = new Config();
            config.useClusterServers().addNodeAddress("redis://192.168.195.129:6379",
                    "redis://192.168.195.129:6378","redis://192.168.195.129:6377","redis://192.168.195.129:6376",
                    "redis://192.168.195.129:6375","redis://192.168.195.129:6377").setPassword("000000").setScanInterval(5000);
        RedissonClient redissonClient = Redisson.create(config);
        List<Integer> userIdList = redissonClient.getList("userIdList");
        System.out.println(userIdList.contains("1"));
    }
}
