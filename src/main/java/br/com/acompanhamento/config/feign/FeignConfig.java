package br.com.acompanhamento.config.feign;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netshoes.mp.commission.gateways.feign.CommissionUatErrorDecoder;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Configuration
@EnableFeignClients(basePackages = "com.netshoes.mp.commission.gateways")
public class FeignConfig {

    @Bean
    public Feign.Builder feignBuilder() {
        // @formatter:off
        return Feign.builder()
                    .encoder(new JacksonEncoder())
                    .decoder(new JacksonDecoder())
                    .errorDecoder(myErrorDecoder())
                    .requestInterceptor(new BasicAuthRequestInterceptor("guest", "guest"));
        // @formatter:on
    }

    @Bean
    public CommissionUatErrorDecoder myErrorDecoder() {
        return new CommissionUatErrorDecoder();
    }

}
