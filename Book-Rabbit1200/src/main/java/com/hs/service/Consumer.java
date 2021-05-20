package com.hs.service;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Huasheng
 * @Date 2021/05/12/15:20
 * @Description
 */
@Slf4j
@Component
public class Consumer implements ChannelAwareMessageListener {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        MessageProperties messageProperties = message.getMessageProperties();

        // 代表投递的标识符，唯一标识了当前信道上的投递，通过 deliveryTag ，消费者就可以告诉 RabbitMQ 确认收到了当前消息，见下面的方法
        long deliveryTag = messageProperties.getDeliveryTag();

        // 如果是重复投递的消息，redelivered 为 true
        Boolean redelivered = messageProperties.getRedelivered();

        // 获取生产者发送的原始消息
        Object originalMessage = rabbitTemplate.getMessageConverter().fromMessage(message);
        log.info("接受到消息：{}",originalMessage);
        // 代表消费者确认收到当前消息，第二个参数表示一次是否 ack 多条消息
        channel.basicAck(deliveryTag, false);
    }
}