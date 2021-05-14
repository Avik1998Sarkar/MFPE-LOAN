package com.loan.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DataCustomerLoan {
	
	private int loanProductId;
	private double loanPrincipal;
	private double tenure;
	private double interest;
	private double emi;
}
