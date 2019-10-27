package joinx.common.mq.exchange.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 接受info消息的类
 * bindings : 绑定队列
 * autoDelete: 当前队列是否是临时可删除队列
 * type: 指定交换器类型
 */
@Component
@RabbitListener(
       bindings = @QueueBinding(
              value = @Queue(value = "${mq.config.exchange.topic.error}",autoDelete = "true"),
              exchange =@Exchange(value = "${mq.config.exchange.topic}",type =ExchangeTypes.TOPIC),
              key = "*.log.topic.error"
       )
       
)
public class TopicErrorReciever {
   //监听消息的变化,消息队列监听机制
   @RabbitHandler //具体处理消息的方法
   public  void process(String msg){
      System.out.println("ERROR ....... Receiver:"+msg);
   }
}
