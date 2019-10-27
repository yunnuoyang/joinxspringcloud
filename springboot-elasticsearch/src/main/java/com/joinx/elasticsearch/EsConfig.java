package com.joinx.elasticsearch;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class EsConfig {
   @Bean
   public TransportClient client() throws UnknownHostException {
      InetSocketTransportAddress node = new InetSocketTransportAddress(
             InetAddress.getByName("localhost"),
             9200);
      Settings settings = Settings.builder()
             .put("elasticsearch", "BamRP_kRR2mjYzzyi_5N5w").build();
      TransportClient client = new PreBuiltTransportClient(settings);
   
      client.addTransportAddress(node);
      return client;
   }
}
