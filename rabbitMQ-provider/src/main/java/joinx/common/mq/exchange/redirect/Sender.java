package joinx.common.mq.exchange.redirect;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sender {
  
  @Autowired
   private AmqpTemplate amqpTemplate;
  @Value("${mq.config.exchange}")
  private String exchange;
  @Value("${mq.config.queue.error.routing.key}")
  private String routingKey;
  
  public void send(String msg){
     
     //向消息队列发送消息
     // 交换器名称，路由键，消息
     System.out.println(exchange+"=="+routingKey);
   this.amqpTemplate.convertAndSend(exchange,routingKey,msg);
  }
}
