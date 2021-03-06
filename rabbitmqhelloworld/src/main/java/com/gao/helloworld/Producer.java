package com.gao.helloworld;

import com.gao.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    static String QUEUE_NAME = "helloqueue";
    static String MSG="hello world";
    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false, null);

        channel.basicPublish("",QUEUE_NAME,null,MSG.getBytes());

        RabbitMqUtil.closeChannelAndConnection(channel,connection);
    }
}
