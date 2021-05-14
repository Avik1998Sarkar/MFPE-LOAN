package com.risk.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DataCollateralCashdeposit {

	
	private int id;
	private String collateralType;
	private String bankname;
	private double currentvalue;
	private double interestrate;
	private double lockperiod;
	}
