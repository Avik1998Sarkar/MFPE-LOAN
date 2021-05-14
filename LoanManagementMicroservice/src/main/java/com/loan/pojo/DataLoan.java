package com.loan.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DataLoan {
	private int id;
	private int maximumLoanEligibilityAmount;
	private double interest;
	private double tenure;
	private DataCustomerLoan customerloan;
	private DataCustomer dataCustomer;
}
