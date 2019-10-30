package com.joinx.app;

import com.joinx.config.TestRibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(value = "joinx-03-eurekaprovider",configuration = TestRibbonConfiguration.class)
public class ApplicationProvider2 {
   public static void main(String[] args) {
      SpringApplication.run(ApplicationProvider2.class,args);
   }
//   @Bean
//   public IClientConfig getIClientConfigInstance(){
//      return new DefaultClientConfigImpl();
//   }
}
