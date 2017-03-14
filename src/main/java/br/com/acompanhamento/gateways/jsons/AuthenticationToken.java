package br.com.acompanhamento.gateways.jsons;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by michelf on 13/03/17.
 */
@Getter
@Setter
@NoArgsConstructor
public class AuthenticationToken implements Serializable {

    private AccessToken accessToken;
    private RefreshToken refreshToken;

}
