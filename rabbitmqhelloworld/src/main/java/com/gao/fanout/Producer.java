package com.gao.fanout;

import com.gao.util.RabbitMqUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    static String EXCHANGE_NAME = "fanoutexchange";
    static String MSG = " = this is fanout Msg";
    static String TYPE= "fanout";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();

        //指定交换机名称与类型
        channel.exchangeDeclare(EXCHANGE_NAME,TYPE);

        channel.basicPublish(EXCHANGE_NAME,"", null,MSG.getBytes());

        RabbitMqUtil.closeChannelAndConnection(channel,connection);
    }
}
