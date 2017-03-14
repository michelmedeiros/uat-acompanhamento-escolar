package br.com.acompanhamento.domains;

import lombok.*;

import java.math.BigDecimal;

/**
 * Created by dgropelo on 20/02/17.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class Plan {

	private Long id;
	private BigDecimal amount;
	private Boolean showCompetitorInfoBusiness;
	private Boolean showCompetitorInfoClients;
	private Boolean showYourBusiness;
	private Boolean showYourClients;

}
