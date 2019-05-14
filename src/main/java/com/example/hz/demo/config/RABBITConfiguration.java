package com.example.hz.demo.config;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RABBITConfiguration {
    @Bean
    public ConnectionFactory connectionFactory(){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("172.16.11.96");
        factory.setAutomaticRecoveryEnabled(true);
        return factory;
    }
}
