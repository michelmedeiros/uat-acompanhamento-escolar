package br.com.acompanhamento.gateways.feign;

import br.com.acompanhamento.domains.Aluno;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "${feign.acompanhamento.name}")
public interface AlunoClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/alunos")
    List<Aluno> buscarAlunos();

    @RequestMapping(value = "/api/v1/alunos/{alunoId}", method = RequestMethod.GET)
    Aluno buscarAluno(@PathVariable(value = "alunoId") final String alunoId);

}
