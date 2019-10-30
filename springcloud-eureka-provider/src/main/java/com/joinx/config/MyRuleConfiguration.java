package com.joinx.config;

import com.joinx.app.ribbon.rule.MyRule;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 使用自己的自定义负载均衡算法，交给ribbon负载服务器
 */
@Configuration
public class MyRuleConfiguration {
   @Autowired
   IClientConfig config ;
   @Bean
   public IRule getMyRule(IClientConfig clientConfig){
      new RoundRobinRule();//轮询算法
      new RandomRule();//随机算法
      return new MyRule();
   }
}
