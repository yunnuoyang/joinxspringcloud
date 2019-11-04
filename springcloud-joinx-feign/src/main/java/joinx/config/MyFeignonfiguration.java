package joinx.config;

import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFeignonfiguration {
   @Bean
   public Contract feignContract() {
      //契约  Default是springmvc的
      return new feign.Contract.Default();
   }
   //#配置feign的日志
   @Bean
   Logger.Level feignLoggerLevel() {
      return Logger.Level.FULL;
   }
   
//   @Bean
//   public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//      return new BasicAuthRequestInterceptor("user", "password");
//   }
}
