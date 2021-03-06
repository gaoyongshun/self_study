package com.gao.routing;

import com.gao.util.RabbitMqUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer1 {

    public static void main(String[] args) throws IOException, TimeoutException {

       Connection connection = RabbitMqUtil.getConnection();

        final Channel channel = connection.createChannel();
        //绑定交换机
        channel.exchangeDeclare(Producer.EXCHANGE_NAME,Producer.TYPE);
        String queueName = channel.queueDeclare().getQueue();

        channel.queueBind(queueName,Producer.EXCHANGE_NAME,"info");
        channel.queueBind(queueName,Producer.EXCHANGE_NAME,"error");

        channel.basicConsume(queueName,false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("routing Msg : "+ new String(body));
            }
        });

    }
}
