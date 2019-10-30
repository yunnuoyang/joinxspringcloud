package com.joinx.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestRibbonConfiguration {
   @Autowired
   IClientConfig config ;
   @Bean
   public IRule ribbonRule(IClientConfig clientConfig){
      //随机进行访问的规则
      return new RandomRule();
   }
}
