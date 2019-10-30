package com.joinx.app.controller;

import com.joinx.app.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
   @Autowired
   private RestTemplate template;
   
   @Autowired
   private LoadBalancerClient loadBalancerClient;
   @GetMapping("/info")
   public String helloEureka(){
      return "Hello,Eureka";
   }
   @GetMapping("/getUser/{id}")
   public User getUser(@PathVariable long id){
      //joinx-02-eurekaprovider VIP: virtual ip 虚拟ip 地址
      //使用restTemplate调用第三方的服务
      return this.template.getForObject("http://joinx-03-eurekaprovider/getUser/"+id,User.class);
   }
   
   @GetMapping("/")
   public String loadBalancer(){
      ServiceInstance serviceInstance = this.loadBalancerClient.choose("joinx-03-eurekaprovider");
      String str = serviceInstance.getHost() + ":" + serviceInstance.getPort() + "" + serviceInstance.getUri();
      System.out.println(str);
      return str;
   }
}
