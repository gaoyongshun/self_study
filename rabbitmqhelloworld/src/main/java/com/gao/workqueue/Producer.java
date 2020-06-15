package com.gao.workqueue;

import com.gao.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Producer {
    static String QUEUE_NAME = "workqueue";
    static String MSG = " = this is work queue";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = RabbitMqUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //消费者平均分配
        for (int i = 0; i < 100; i++) {
            channel.basicPublish("", QUEUE_NAME, null, (i + MSG).getBytes());
        }

        RabbitMqUtil.closeChannelAndConnection(channel, connection);
    }
}
