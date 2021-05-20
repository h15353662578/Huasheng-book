package com.hs.rabbit.controller;

import com.hs.rabbit.config.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Huasheng
 * @Date 2021/05/12/10:57
 * @Description
 */
@Slf4j
@RequestMapping
@RestController
public class TestController {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMsg")
    public String sendMsg(@RequestParam Integer sendUserId, @RequestParam Integer recUserId, String msg ){
        MessageProperties messageProperties = new MessageProperties();
        String messageBody = msg;
        Message message = rabbitTemplate.getMessageConverter().toMessage(messageBody, messageProperties);
        String key = Constant.REDIS_KEY+recUserId;
        Object o = redisTemplate.opsForValue().get(key);
        if(o == null){
            throw new RuntimeException("recUserId未建立连接:"+recUserId);
        }
        rabbitTemplate.convertAndSend(Constant.TOPIC, o.toString(),message);
        return "success";
    }

    @GetMapping("/buildRoutingKey")
    public String buildRoutingKey(@RequestParam Integer recUserId){

        String key = Constant.REDIS_KEY+recUserId;
        log.info("key={},value={}",key,Constant.ROUTING_KEY);
        redisTemplate.opsForValue().set(key,Constant.ROUTING_KEY);
        return "success";
    }
}