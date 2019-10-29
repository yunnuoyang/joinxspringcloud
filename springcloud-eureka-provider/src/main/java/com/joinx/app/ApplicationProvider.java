package com.joinx.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务提供者
 */

@SpringBootApplication
@EnableEurekaClient
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
