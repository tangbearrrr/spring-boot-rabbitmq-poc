package com.tangbear.rabbitmqpoc.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqReceiver {

    @RabbitListener(queues = "${rabbit.mq.default.queue}")
    public void receiveMessage(String message) {
        System.out.println("Receive message from rabbitMQ: " + message);
    }
}
