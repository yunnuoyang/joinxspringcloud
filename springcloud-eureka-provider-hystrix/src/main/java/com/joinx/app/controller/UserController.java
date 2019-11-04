package com.joinx.app.controller;

import com.joinx.app.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
   
   @Autowired
   private RestTemplate template;
   
   @Autowired
   private LoadBalancerClient loadBalancerClient;
   @GetMapping("/getUser/{id}")
   @HystrixCommand(fallbackMethod = "getUserFallback")
   public User getUser(@PathVariable long id){
//      ServiceInstance serviceInstance = this.loadBalancerClient.choose("joinx-03-eurekaprovider");
//      String str = serviceInstance.getHost() + ":" + serviceInstance.getPort() + "" + serviceInstance.getUri();
//      System.out.println(str);
//      //joinx-02-eurekaprovider VIP: virtual ip 虚拟ip 地址
      //使用restTemplate调用第三方的服务
      return this.template.getForObject("http://joinx-03-eurekaprovider/getUser/"+id,User.class);
   }
   public User getUserFallback( long id){
      User user=new User();
      user.setID(99l);
      user.setName("hystrixFallback");
      return user;
   }
   
   
   @PostMapping("/addUser")
   public User addUser(@RequestBody User user){
      System.out.println(user.getID()+"===="+user.getName());
   
      return user;
   }
}
