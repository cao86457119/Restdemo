package com.example.hz.demo.demos;


import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.*;

public class RMQConsumer {
    private final static String QUEUE_NAME = "qos_queue";
    private final static String EXCHANGE_NAME="test_qos_exchange";
    private final static String ROUTINGKEY="qos.#";


    public static void main(String... args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("172.16.11.96");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = null;
        try {
            connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME,"topic",true,false,null);
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,ROUTINGKEY);

            channel.basicQos(100);
            boolean autoAck = false;
            channel.basicConsume(QUEUE_NAME, autoAck, "",new dConsumer(channel));


//func 2

//            GetResponse response = channel.basicGet(QUEUE_NAME, autoAck);
//            if (response == null) {
//                //未检索到任何消息。
//            } else {
//                AMQP.BasicProperties props = response.getProps();
//                byte[] body = response.getBody();
//                System.out.println(new String(body));
//                long deliveryTag = response.getEnvelope().getDeliveryTag();
//                channel.basicAck(deliveryTag, false);
//            }

        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
