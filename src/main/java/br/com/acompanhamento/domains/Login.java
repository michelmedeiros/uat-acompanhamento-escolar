package br.com.acompanhamento.domains;

import lombok.*;

/**
 * Created by michelf on 14/03/17.
 */
@Data
public class Login extends BasicCredentials {

    /** Senha */
    private String password;

    @Builder
    public Login(String merchant, String username, String password) {
        super(merchant, username);
        this.password= password;
    }


}