package br.com.acompanhamento.domains;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "alunos")
public class Aluno {

    @Id
    private String id;

    private String nome;

    private int idade;

}
