package com.gao.bootrabbitmq.cosummer;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RouteDirectConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value= @Queue,
                    exchange =  @Exchange(name = "route_direct",type ="direct"),
                    key ={"info","error","debug"}
            )
    })
    public void handler(String msg){
        System.out.println("this is route direct msg1 :"+msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value= @Queue,
                    exchange =  @Exchange(name = "route_direct",type ="direct"),
                    key ={"error"}
            )
    })
    public void handler2(String msg){
        System.out.println("this is route direct msg2 :"+msg);
    }
}
