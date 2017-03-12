package br.com.acompanhamento.stepdefinitions;

import br.com.acompanhamento.domains.Aluno;
import br.com.acompanhamento.gateways.feign.AlunoClient;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

import java.util.List;

/**
 * Created by Michel Medeiros on 11/03/2017.
 */
public class BuscarEstudantesDefinitions {
    private List<Aluno> alunosExistentes;
    private AlunoClient alunoClient;

    @Dado("^alunos existentes:$")
    public void alunosExistentes(List<Aluno> alunos) throws Throwable {
        System.out.println("alunosExistentes");
        this.alunosExistentes = alunos;
    }

    @E("^um filtro com id \"([^\"]*)\"$")
    public void umFiltroComCnpjEDataFim(String id) throws Throwable {
        System.out.println("umFiltroComCnpjEDataFim");
        Aluno alunoEncontrado = alunoClient.buscar(id);
    }

    @Quando("^eu busco estudantes$")
    public void euBuscoEstudantes() throws Throwable {
        System.out.println("euBuscoEstudantes");
    }

    @Entao("^os estudantes são retornados$")
    public void osEstudantesSaoRetornados() throws Throwable {
        System.out.println("osEstudantesSãoRetornados");
    }
}
