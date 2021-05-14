package com.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "collateral_cashdeposit")
public class CollateralCashdeposit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "collateral_type")
	private String collateralType;
	@Column(name = "bank_name")
	private String bankname;
	@Column(name = "current_value")
	private double currentvalue;
	@Column(name = "interest_rate")
	private double interestrate;
	@Column(name = "lock_period")
	private double lockperiod;
	@OneToOne
	@JoinColumn(name="loan_id") 
	private CollateralLoan collateralLoan;
	}
