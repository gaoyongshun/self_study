package com.gao.topic;

import com.gao.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    static String EXCHANGE_NAME="exchange_topic";
    static String TYPE="topic";
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMqUtil.getConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,TYPE);

        String routingKey="hello.world";

        channel.basicPublish(EXCHANGE_NAME,routingKey,null,"this is topic ".getBytes());

        RabbitMqUtil.closeChannelAndConnection(channel,connection);
    }
}
