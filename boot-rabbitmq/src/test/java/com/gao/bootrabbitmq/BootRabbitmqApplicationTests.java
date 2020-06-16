package com.gao.bootrabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = BootRabbitmqApplication.class)
public class BootRabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testRouteTopic(){
        rabbitTemplate.convertAndSend("route_topic","user.save","topic msg");
        rabbitTemplate.convertAndSend("route_topic","user.save.hello","topic msg  33");

    }

    @Test
    public void testRoutDirect(){
        rabbitTemplate.convertAndSend("route_direct","info","route direct msg");
        rabbitTemplate.convertAndSend("route_direct","error","route direct msg");
    }

    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("fanout_exchange","","fanout msg");
    }

    @Test
    public void testHello() {
        rabbitTemplate.convertAndSend("hello", "123");
    }

    @Test
    public void testWork() {
        for (int i = 0; i < 10; i++)
            rabbitTemplate.convertAndSend("work", "this is work msg");
    }
}
