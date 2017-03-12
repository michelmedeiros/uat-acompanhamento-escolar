package br.com.acompanhamento.gateways.mongo;

import br.com.acompanhamento.domains.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlunoRepositoy extends MongoRepository<Aluno, String> {
    Aluno findById(String id);
}
