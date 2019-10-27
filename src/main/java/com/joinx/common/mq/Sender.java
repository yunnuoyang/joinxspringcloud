package com.joinx.common.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
  @Autowired
   private AmqpTemplate amqpTemplate;
  public void send(String msg){
     //向消息队列发送消息
     
   this.amqpTemplate.convertAndSend("rabbitMQ-hello",msg);
  }
}
