package com.risk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Collateral_Market_Value")
public class CollateralMarketValue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "interest_rate")
	private double interestrate;
	@Column(name = "bank_name")
	private String bankname;
	@Column(name = "address")
	private String address;
	@Column(name = "ratepersqft")
	private double ratepersqft;
	

}
