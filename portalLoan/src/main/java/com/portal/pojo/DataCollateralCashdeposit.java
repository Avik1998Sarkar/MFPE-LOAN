package com.portal.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DataCollateralCashdeposit {

	private String collateralType;

	private String bankname;

	private double currentvalue;

	private double interestrate;

	private double lockperiod;

}
