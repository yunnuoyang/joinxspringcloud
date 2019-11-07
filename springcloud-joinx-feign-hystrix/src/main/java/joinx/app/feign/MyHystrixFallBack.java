package joinx.app.feign;

import joinx.app.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class MyHystrixFallBack implements StoreClient2{
   @Override
   public User getUser(long id) {
      User user=new User();
      user.setID(id);
      user.setName("feign-hystrix-fallback");
      return user;
   }
}