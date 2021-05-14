package com.risk.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "collateral_risk")
public class CollateralRisk {

	
	@Id
	@Column(name = "loan_id")
	private int loanid;
	
	@Column(name = "risk_percent")
	private double riskpercent;
	
	@Column(name = "Date_Assessed")
	private Date dateAssessed;
	
	@Column(name = "Sanctioned_Loan")
	private double sanctionedLoan;
	
	@Column(name = "market_current_value")
	private double marketCurrentValue;
	
	}
