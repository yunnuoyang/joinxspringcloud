import com.joinx.ApplicationSever;
import com.joinx.common.mq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationSever.class)
public class QueueTest {
   @Autowired
   private Sender sender;
   /**
    * 测试消息队列
    */
   @Test
   public void sendToMQ(){
      this.sender.send("你好啊,RabbitMQ");
   }
}
