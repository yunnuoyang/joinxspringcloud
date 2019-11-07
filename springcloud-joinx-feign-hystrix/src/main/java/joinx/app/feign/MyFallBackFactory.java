package joinx.app.feign;

import feign.hystrix.FallbackFactory;
import joinx.app.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
//自定义的 histrix 集成 fegin 的 fallbackFactory
@Component
public class MyFallBackFactory implements FallbackFactory<StoreClient2> {
   
   private  static Logger logger=LoggerFactory.getLogger(MyFallBackFactory.class);
   @Override
   public StoreClient2 create(Throwable throwable) {
      logger.info("fallback reason was: {}",throwable.getMessage());
      return new MyFeignHystrixFallBackFactoryClient() {
         @Override
         public User getUser(long id) {
            User user=new User();
            user.setID(id);
            user.setName("joinx-fegin-hystrix-fallbackfactory");
            return user;
         }
      };
   }
}
interface MyFeignHystrixFallBackFactoryClient extends StoreClient2{

}
