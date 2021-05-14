package com.risk.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DataCollateralRealestate {
	
	private int id;
	private String collateralType;
	private String address;
	private double currentvalue;
	private double ratepersqft;
	private double depreciationrate;
	
	}
