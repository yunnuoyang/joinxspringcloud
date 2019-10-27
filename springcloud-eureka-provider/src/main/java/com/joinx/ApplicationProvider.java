package com.joinx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务提供者
 */

@SpringBootApplication
@EnableEurekaClient
public class ApplicationProvider {
   public static void main(String[] args) {
      SpringApplication.run(ApplicationProvider.class,args);
   }
}
