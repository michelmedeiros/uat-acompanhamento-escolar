package br.com.acompanhamento.gateways.feign;

import javax.validation.Valid;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.netshoes.mp.commission.domain.Cycle;
import com.netshoes.mp.commission.gateways.jsons.CloseCycleRequest;
import com.netshoes.mp.commission.gateways.jsons.PagedObject;

@FeignClient(value = "${feign.mp-commission.name}")
public interface AlunoClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/cycles")
    PagedObject<Cycle> getCycles(@RequestParam(value = "cnpj") String cnpj, @RequestParam(value = "offset", required = false) Integer offset,
                                 @RequestParam(value = "limit", required = false) Integer limit);

    @RequestMapping(value = "/api/v1/cycles/{cycleId}", method = RequestMethod.GET)
    Cycle getById(@PathVariable(value = "cycleId") final String cycleId);

    @RequestMapping(method = RequestMethod.POST, value = "/api/v1/cycles")
    Cycle closeCycle(@RequestBody @Valid CloseCycleRequest request);
}