package br.com.acompanhamento.gateways.feign;

import br.com.acompanhamento.gateways.jsons.BackofficePlanResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by michelf on 13/03/17.
 */
@Path("")
@FeignClient(value = "${feign.farol-backoffice-service.name}")
public interface BackofficeClient {


//    @GET
//    @Path("/farol/backoffice/plans")
    @RequestMapping(method = RequestMethod.GET, value = "/farol/backoffice/plans")
    BackofficePlanResult findPlans();

}
