package br.com.acompanhamento.gateways.jsons;

import br.com.acompanhamento.domains.Plan;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class BackofficePlanResult implements Serializable {

	private static final long serialVersionUID = 5113238320711224936L;

	private List<Plan> plans;

}
