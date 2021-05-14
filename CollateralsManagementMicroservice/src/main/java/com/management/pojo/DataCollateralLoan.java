package com.management.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DataCollateralLoan {

	private int loanId;
	private String collateralName;
	private double collateralValue;
	private Date pledgedDate;

	private DataCollateralRealestate collateralRealestate;
	private DataCollateralCashdeposit collateralCashdeposit;

}
