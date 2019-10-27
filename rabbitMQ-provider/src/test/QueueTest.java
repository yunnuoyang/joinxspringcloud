
import joinx.ApplicationSever;
import joinx.common.mq.exchange.redirect.Sender;
import joinx.common.mq.exchange.topic.OrderSender;
import joinx.common.mq.exchange.topic.ProductSender;
import joinx.common.mq.exchange.topic.UserSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationSever.class)
public class QueueTest {
   @Autowired
   private Sender sender;
   @Autowired
   private OrderSender orderSender;
   @Autowired
   private ProductSender productSender;
   @Autowired
   private UserSender userSender;
   @Autowired
   private joinx.common.mq.exchange.fanout.FanOutOrderSender fanOutOrder;
   @Autowired
   private joinx.common.mq.exchange.fanout.FanOutProductSender fanOutproductSender;
   @Autowired
   private joinx.common.mq.exchange.fanout.FanOutUserSender fanOutuserSender;
   
   /**
    * 测试消息队列direct
    */
   @Test
   public void sendToMQ() throws InterruptedException {
      while(true){
         Thread.sleep(1000);
         this.sender.send("你好啊,RabbitMQ");
      }
      
   }
   /**
    * 测试消息队列topic 交换器
    */
   @Test
   public void sendToMQTopic(){
        orderSender.send("hi ,order 发送新消息");
        productSender.send("hi ,product 发送新消息");
        userSender.send("hi ,user 发送新消息");
   }
   /**
    * 测试消息队列topic 交换器
    */
   @Test
   public void sendToMQFanout(){
        fanOutOrder.send("hi ,order 发送新消息");
        fanOutproductSender.send("hi ,product 发送新消息");
        fanOutuserSender.send("hi ,user 发送新消息");
   }
}
