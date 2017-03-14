package br.com.acompanhamento.gateways.feign;

import br.com.acompanhamento.domains.Login;
import br.com.acompanhamento.gateways.jsons.AuthenticationToken;
import br.com.acompanhamento.gateways.jsons.RequestAuthentication;
import feign.HeaderMap;
import feign.Headers;
import feign.RequestLine;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by michelf on 13/03/17.
 */

@FeignClient(value = "${feign.authentication.name}")
public interface AuthenticationClient {
    @Headers("Content-Type: application/json")
//    @RequestMapping(method = RequestMethod.POST, value = "/authentication")
    @RequestLine("POST /authentication")
    AuthenticationToken authentication(final Login login);

}