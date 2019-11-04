package joinx.app.feign;

import feign.Param;
import feign.RequestLine;
import joinx.app.pojo.User;
import joinx.config.MyFeignonfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "joinx-03-eurekaprovider",configuration = MyFeignonfiguration.class)
public interface StoreClient2 {
   @RequestLine(value = "GET /getUser/{id}")
   public User getUser(@Param("id") long id);//必须绑定参数
   
//   @RequestLine(value = "/addUser")
//   public User addUser(@RequestBody User user);
}
