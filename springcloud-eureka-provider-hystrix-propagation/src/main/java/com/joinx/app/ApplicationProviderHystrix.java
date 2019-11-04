package com.joinx.app;

import com.joinx.config.TestRibbonConfiguration;
import com.netflix.hystrix.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@RibbonClient(value = "joinx-03-eurekaprovider",configuration = TestRibbonConfiguration.class)
public class ApplicationProviderHystrix {
   public static void main(String[] args) {
      SpringApplication.run(ApplicationProviderHystrix.class,args);
   }
//   @Bean
//   public IClientConfig getIClientConfigInstance(){
//      return new DefaultClientConfigImpl();
//   }
//   HystrixCommand
   
   @Bean
   @LoadBalanced  //整合了ribben,具备了ribben 的能力
   public RestTemplate newInstanceRestTemplate(){
      return new RestTemplate();
   }
}
