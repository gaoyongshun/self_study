package com.gao.bootrabbitmq.cosummer;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RouteTopicConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value= @Queue,
                    exchange =  @Exchange(name = "route_topic",type ="topic"),
                    key ={"user.#","hello.user"}
            )
    })
    public void handler(String msg){
        System.out.println("this is route topic msg1 :"+msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value= @Queue,
                    exchange =  @Exchange(name = "route_topic",type ="topic"),
                    key ={"user.*"}
            )
    })
    public void handler2(String msg){
        System.out.println("this is route topic msg2 :"+msg);
    }
}
