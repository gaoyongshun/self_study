package com.gao.bootrabbitmq.cosummer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkConsumer {

    @RabbitListener(queuesToDeclare = @Queue(name = "work"))
    public void handler(String msg){
        System.out.println("1 work queue = "+msg );
    }

    @RabbitListener(queuesToDeclare = @Queue(name = "work"))
    public void handler2(String msg){
        System.out.println("2 work queue = "+msg );
    }
}
