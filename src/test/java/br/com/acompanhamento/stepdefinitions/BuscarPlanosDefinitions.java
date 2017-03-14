package br.com.acompanhamento.stepdefinitions;

import br.com.acompanhamento.domains.Login;
import br.com.acompanhamento.domains.Plan;
import br.com.acompanhamento.gateways.feign.AuthenticationClient;
import br.com.acompanhamento.gateways.feign.BackofficeClient;
import br.com.acompanhamento.gateways.jsons.AuthenticationToken;
import br.com.acompanhamento.gateways.jsons.BackofficePlanResult;
import br.com.acompanhamento.gateways.jsons.RequestAuthentication;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
 * Created by michelf on 13/03/17.
 */
public class BuscarPlanosDefinitions {

    public static final String API_URL = "https://digitalhml.hdevelo.com.br";

    private final BackofficeClient backofficeClient;

    @Autowired
    public BuscarPlanosDefinitions(BackofficeClient backofficeClient) {
        this.backofficeClient = backofficeClient;
    }

    @Dado("^planos existentes:$")
    public void planosExistentes(List<Plan> planos) throws Throwable {
    }

    @Dado("^Usuário autenticado com acesso ao sistema$")
    public void usuarioAutenticadoComAcessoAoSistema() throws Throwable {

        AuthenticationClient auth = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(AuthenticationClient.class, API_URL);

        Login login = Login.builder().password("s@1003299951")
                .merchant("1003299951").username("1003299951").build();
        AuthenticationToken token = auth.authentication(login);


        System.out.print(token.getAccessToken());
    }

    @Quando("^eu busco planos$")
    public void euBuscoPlanos() throws Throwable {
        BackofficePlanResult resultado = backofficeClient.findPlans();
        System.out.println(resultado);
    }

    @Entao("^os planos são retornados$")
    public void osPlanosSãoRetornados() throws Throwable {
    }


}
