package com.joinx.common.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Reciever {
   //监听消息的变化,消息队列监听机制
   @RabbitListener(queues = {"rabbitMQ-hello"})
   public  void process(String msg){
      System.out.println("rabbitMQ-hello 队列监听到的消息"+msg);
   }
}
