package br.com.acompanhamento.config.feign;

import br.com.acompanhamento.gateways.feign.UatErrorDecoder;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Configuration
@EnableFeignClients(basePackages = "br.com.acompanhamento.gateways")
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
    public UatErrorDecoder myErrorDecoder() {
        return new UatErrorDecoder();
    }

}
