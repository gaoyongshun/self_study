package com.gao.bootrabbitmq.cosummer;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutConsumer {


    @RabbitListener(bindings = {@QueueBinding(
            value=@Queue,
            exchange = @Exchange(value = "fanout_exchange",type="fanout")
    )})
    public void handler(String msg){
        System.out.println("this is fanoutConsumer1 = " +msg);
    }

    @RabbitListener(bindings = {@QueueBinding(
            value=@Queue,
            exchange = @Exchange(value = "fanout_exchange",type="fanout")
    )})
    public void handler2(String msg){
        System.out.println("this is fanoutConsumer2 = " +msg);
    }
}
