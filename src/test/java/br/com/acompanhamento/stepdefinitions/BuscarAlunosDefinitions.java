package br.com.acompanhamento.stepdefinitions;

import br.com.acompanhamento.ApplicationConfiguration;
import br.com.acompanhamento.domains.Aluno;
import br.com.acompanhamento.gateways.feign.AlunoClient;
import br.com.acompanhamento.gateways.feign.BackofficeClient;
import br.com.acompanhamento.gateways.jsons.BackofficePlanResult;
import br.com.acompanhamento.gateways.mongo.AlunoRepositoy;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

/**
 * Created by Michel Medeiros on 11/03/2017.
 */
@SpringApplicationConfiguration(classes = ApplicationConfiguration.class)
public class BuscarAlunosDefinitions {
    private List<Aluno> alunosExistentes;
    private Aluno alunoEncontrado;
    private final AlunoClient alunoClient;
    private final AlunoRepositoy alunoRepositoy;


    @Autowired
    public BuscarAlunosDefinitions(AlunoClient alunoClient, AlunoRepositoy alunoRepositoy) {
        this.alunoClient = alunoClient;
        this.alunoRepositoy = alunoRepositoy;
    }

    @Dado("^alunos existentes:$")
    public void alunosExistentes(List<Aluno> alunos) throws Throwable {
        this.alunosExistentes = alunoRepositoy.save(alunos);
    }

    @Quando("^eu busco estudantes com id \"([^\"]*)\"$")
    public void euBuscoEstudantesComId(String id) throws Throwable {
        this.alunoEncontrado = alunoClient.buscarAluno(id);
    }

    @Entao("^os estudantes são retornados$")
    public void osEstudantesSaoRetornados() throws Throwable {
        assertThat(alunosExistentes, hasItem(alunoEncontrado));
    }
}
