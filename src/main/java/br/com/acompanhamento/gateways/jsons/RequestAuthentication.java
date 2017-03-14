package br.com.acompanhamento.gateways.jsons;

import lombok.*;

import java.io.Serializable;

/**
 * Created by michelf on 13/03/17.
 */
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestAuthentication implements Serializable{

    private String merchant;
    private String username;
    private String password;
}
