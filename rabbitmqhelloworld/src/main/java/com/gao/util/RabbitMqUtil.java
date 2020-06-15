package com.gao.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMqUtil {

    public static ConnectionFactory connectionFactory;

    static {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.86.128");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("ems");
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");
    }

    public static Connection getConnection() {
        try {
            Connection connection = connectionFactory.newConnection();
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeChannelAndConnection(Channel channel, Connection connection) throws IOException, TimeoutException {
        if (channel != null) {
            channel.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
