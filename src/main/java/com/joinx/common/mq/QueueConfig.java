package com.joinx.common.mq;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class QueueConfig {
   @Bean
   public Queue createQueue(){
      return new Queue("rabbitMQ-hello");
   }
}
