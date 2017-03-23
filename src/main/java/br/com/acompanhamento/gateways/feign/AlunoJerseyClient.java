package br.com.acompanhamento.gateways.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@FeignClient(value = "${feign.acompanhamento.name}")
public interface AlunoJerseyClient {
    @GET
    @Path("hello")
    String helloWorld();
}
