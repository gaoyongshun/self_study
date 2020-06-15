package com.gao.helloworld;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setVirtualHost("ems");
        connectionFactory.setHost("192.168.86.128");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(Producer.QUEUE_NAME, false, false, false, null);
        channel.basicConsume(Producer.QUEUE_NAME, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("==========="+new String(body));
            }
        });
//        channel.close();
//        connection.close();
    }
}
