package com.gao.bootrabbitmq.cosummer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue(name="hello"))
public class HelloConsumer {

    @RabbitHandler
    public void hanler(String msg){
        System.out.println("this is helloConsumer: "+ msg);
    }
}
