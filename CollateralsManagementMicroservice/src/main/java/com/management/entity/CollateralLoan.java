package com.management.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "collateral_loan")
public class CollateralLoan {

	@Id
	@Column(name = "loan_id")
	private int loanId;
	@Column(name = "collateral_name")
	private String collateralName;
	@Column(name = "collateral_value")
	private double collateralValue;
	@Column(name = "pledged_date")
	private Date pledgedDate;
	
	@OneToOne(mappedBy="collateralLoan",cascade = CascadeType.ALL)
	private CollateralRealestate collateralRealestate;
	
	@OneToOne(mappedBy="collateralLoan",cascade = CascadeType.ALL)
	private CollateralCashdeposit collateralCashdeposit;

}
