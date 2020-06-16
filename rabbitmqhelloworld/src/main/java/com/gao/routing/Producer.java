package com.gao.routing;

import com.gao.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    static String EXCHANGE_NAME = "routing_direct";
    static String MSG = " = this is routing-direct Msg";
    static String TYPE= "direct";//路由 直连

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();

        //指定交换机名称与类型
        channel.exchangeDeclare(EXCHANGE_NAME,TYPE);

        //发布基于routing_key的消息
        String routingKey="info";
        channel.basicPublish(EXCHANGE_NAME,routingKey, null,(MSG+" = "+routingKey).getBytes());
        routingKey="error";
        channel.basicPublish(EXCHANGE_NAME,routingKey, null,(MSG+" = "+routingKey).getBytes());
        routingKey="";
        channel.basicPublish(EXCHANGE_NAME,routingKey, null,(MSG+" = "+routingKey).getBytes());
        RabbitMqUtil.closeChannelAndConnection(channel,connection);
    }
}
