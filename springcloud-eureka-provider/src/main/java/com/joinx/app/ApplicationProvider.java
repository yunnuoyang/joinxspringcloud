package com.joinx.app;

import com.joinx.config.MyRuleConfiguration;
import com.joinx.config.TestRibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务提供者
 */

@SpringBootApplication
@EnableEurekaClient
//具备负载能力的服务,指定服务名称，使用不同的规则进行负载
//@RibbonClient(value = "joinx-03-eurekaprovider",configuration = MyRuleConfiguration.class)
@RibbonClient(value = "joinx-03-eurekaprovider",configuration = TestRibbonConfiguration.class)
public class ApplicationProvider {
   public static void main(String[] args) {
      SpringApplication.run(ApplicationProvider.class,args);
   }
   
   @Bean
   @LoadBalanced  //整合了ribben,具备了ribben 的能力
   public RestTemplate newInstanceRestTemplate(){
      return new RestTemplate();
   }
}
