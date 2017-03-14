package br.com.acompanhamento.gateways.feign;

import br.com.acompanhamento.domains.Login;
import br.com.acompanhamento.gateways.jsons.AccessToken;
import br.com.acompanhamento.gateways.jsons.AuthenticationToken;
import br.com.acompanhamento.gateways.jsons.RefreshToken;
import feign.Feign;
import feign.Headers;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;


public final class SimpleService {
    public static final String API_URL = "https://digitalhml.hdevelo.com.br";

    public static void main(String... args) {
        AuthenticationClient auth = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(AuthenticationClient.class, API_URL);

        Login login = Login.builder().password("s@1003299951")
                .merchant("1003299951").username("1003299951").build();
        AuthenticationToken token = auth.authentication(login);


        System.out.print(token.getAccessToken());

    }

}