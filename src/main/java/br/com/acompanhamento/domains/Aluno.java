package br.com.acompanhamento.domains;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "alunos")
public class Aluno {

    private String id;

    private String nome;

    private int idade;

}
