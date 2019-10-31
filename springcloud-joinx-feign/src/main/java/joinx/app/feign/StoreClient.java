package joinx.app.feign;

import joinx.app.pojo.User;
import joinx.config.MyFeignonfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 使用rest的api完全可以完成rpc远程服务调用
 */
//@FeignClient(name = "joinx-03-eurekaprovider",configuration = MyFeignonfiguration.class)
public interface StoreClient {
   @GetMapping(value = "/getUser/{id}")
   public String getUser(@PathVariable("id") long id);//必须绑定参数
   
   @PostMapping("/addUser")
   public User addUser(@RequestBody User user);
}
