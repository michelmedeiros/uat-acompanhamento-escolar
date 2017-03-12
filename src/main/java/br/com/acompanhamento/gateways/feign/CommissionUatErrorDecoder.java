package br.com.acompanhamento.gateways.feign;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CommissionUatErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        return defaultErrorDecoder.decode(methodKey, response);
    }

}