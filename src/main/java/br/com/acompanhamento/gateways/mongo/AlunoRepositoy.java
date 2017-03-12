package br.com.acompanhamento.gateways.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.netshoes.mp.commission.domain.Cycle;

public interface CycleRespository extends MongoRepository<Cycle, String> {
    Cycle findFirstByProviderCnpjOrderByEndDateDesc(String providerCnpj);
}
