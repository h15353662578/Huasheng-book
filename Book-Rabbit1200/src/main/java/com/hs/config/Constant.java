package com.hs.rabbit.config;

import java.util.Date;
import java.util.UUID;

/**
 * @author Huasheng
 * @Date 2021/05/12/10:51
 * @Description
 */
public interface Constant {

    //队列名称
    String QUEUE = "queue:"+ UUID.randomUUID().toString();

    //路由键
    String ROUTING_KEY = "routingKey:"+new Date().getTime();

    //固定值 主题
    String TOPIC = "topic";

    //redisKey
    String REDIS_KEY = "redisKey:";
}
