package com.gao.workqueue;

import com.gao.util.RabbitMqUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer2 {

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = RabbitMqUtil.getConnection();

        final Channel channel = connection.createChannel();
        channel.basicQos(1);
        channel.queueDeclare(Producer.QUEUE_NAME, false, false, false, null);
        channel.basicConsume(Producer.QUEUE_NAME, false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===========" + new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
//        channel.close();
//        connection.close();
    }
}
