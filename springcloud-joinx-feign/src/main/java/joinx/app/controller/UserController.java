package joinx.app.controller;

import joinx.app.feign.StoreClient;
import joinx.app.feign.StoreClient2;
import joinx.app.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
   @Autowired
   private StoreClient2 storeClient;
   
   @RequestMapping(value = "/getUser/{id}",method = RequestMethod.GET)
   public User getUser(@PathVariable long id){
      System.out.println("asdfgfhdfgsdfsSDd");
      User user=new User();
      user.setName("joinx");
      user.setID(1l);
      return user;
   }
   @RequestMapping(value = "/feign/{id}")
   
   public User feignDemo(@PathVariable long id){
      System.out.println("feignDemo ......"+id);
      return storeClient.getUser(id);
   }
   @RequestMapping(value = "/addUser",method = RequestMethod.POST)
   public User addUserByFeign(@RequestBody User user){
        System.out.println(user.getID()+"===="+user.getName());
//      return storeClient.addUser(user);
      return null;
   }
   
}
