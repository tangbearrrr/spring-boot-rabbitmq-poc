package com.tangbear.rabbitmqpoc.consumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMqConfig {

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.virtual-host}")
    private String vHost;

    @Value("${spring.rabbitmq.uri}")
    private String uri;

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connection());
        factory.setConcurrentConsumers(5);
        factory.setMaxConcurrentConsumers(10);
        return  factory;
    }

    @Bean
    public ConnectionFactory connection() {
        CachingConnectionFactory connection = new CachingConnectionFactory();
        connection.setUsername(username);
        connection.setPassword(password);
        connection.setVirtualHost(vHost);
        connection.setUri(uri);
        return connection;
    }
}
