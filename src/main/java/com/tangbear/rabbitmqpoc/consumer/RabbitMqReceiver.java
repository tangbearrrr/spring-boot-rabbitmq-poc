package com.tangbear.rabbitmqpoc.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tangbear.rabbitmqpoc.model.Person;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RabbitMqReceiver {

    @RabbitListener(queues = "${spring.rabbitmq.default.queue}")
    public void receiveMessage(String message) throws JsonProcessingException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(message, Person.class);
        System.out.println("Receive message from rabbitMQ: " + person.toString() + "TIME : " + new Date());
    }
}
