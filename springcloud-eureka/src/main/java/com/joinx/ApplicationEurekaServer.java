package com.joinx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务消费者：即server注册中心
 */
@EnableEurekaServer  //核心注解
@SpringBootApplication
public class ApplicationEurekaServer {
   public static void main(String[] args) {
      SpringApplication.run(ApplicationEurekaServer.class,args);
   }
}
