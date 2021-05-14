package com.portal.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DataCollateralRisk {

	private int loanid;
	private double riskpercent;
	private Date dateAssessed;
	private double sanctionedLoan;
	private double marketCurrentValue;
}
