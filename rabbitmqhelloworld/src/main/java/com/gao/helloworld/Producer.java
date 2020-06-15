package com.gao.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    static String QUEUE_NAME = "helloqueue";
    static String MSG="hello world";
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("192.168.86.128");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("ems");
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false, null);

        channel.basicPublish("",QUEUE_NAME,null,MSG.getBytes());

        channel.close();
        connection.close();
    }
}
