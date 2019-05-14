package com.example.hz.demo.demos;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class  RMQSend {
    private final static String QUEUE_NAME="qos_queue";
    private final static String EXCHANGE_NAME="test_qos_exchange";
    private final static String ROUTINGKEY="qos.save";
    public static void main(String...args){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("172.16.11.96");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setVirtualHost("/");
        try(Connection connection = factory.newConnection()){
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME,true,false,false,null);
            for(int i=0;i<100;i++) {
                channel.basicPublish(EXCHANGE_NAME, ROUTINGKEY, null, "hello,rabbitmq".getBytes());

            }
            channel.close();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
