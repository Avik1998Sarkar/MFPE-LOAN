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
@Table(name = "collateral_realestate")
public class CollateralRealestate {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "collateral_type")
	private String collateralType;
	@Column(name = "address")
	private String address;
	@Column(name = "current_value")
	private double currentvalue;
	@Column(name = "rate_per_sq_ft")
	private double ratepersqft;
	@Column(name = "depreciation_rate")
	private double depreciationrate;
	
	@OneToOne
	@JoinColumn(name="loan_id") 
	private CollateralLoan collateralLoan;
	
	}
