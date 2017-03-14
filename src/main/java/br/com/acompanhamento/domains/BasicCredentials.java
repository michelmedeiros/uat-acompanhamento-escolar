package br.com.acompanhamento.domains;


import lombok.*;

@Data
@NoArgsConstructor
public class BasicCredentials {

    private String merchant;

    private String username;

    public BasicCredentials(String merchant, String username) {
        this.merchant = merchant;
        this.username = username;
    }

}