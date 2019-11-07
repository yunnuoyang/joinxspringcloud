package com.joinx.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(value = "joinx-03-eurekaprovider",configuration = TestRibbonConfiguration.class)
public class ApplicationProviderForOtherClientUse {
   public static void main(String[] args) {
      SpringApplication.run(ApplicationProviderForOtherClientUse.class,args);
   }
//   @Bean
//   public IClientConfig getIClientConfigInstance(){
//      return new DefaultClientConfigImpl();
//   }
}
