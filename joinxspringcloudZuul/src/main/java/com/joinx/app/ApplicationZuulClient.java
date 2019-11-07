package com.joinx.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ApplicationZuulClient {
   public static void main(String[] args) {
      SpringApplication.run(ApplicationZuulClient.class,args);
   }
}
