package com.portal.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CollateralLoanJSP {

	@Min(value = 1, message = "{error.loanId.negative}")
	@NotEmpty(message = "{error.loanId.data}")
	private String loanId;

	@Min(value = 1, message = "{error.collateralValue.negative}")
	@NotEmpty(message = "{error.collateralValue.data}")
	private String collateralValue;

	@Min(value = 1, message = "{error.tenure.negative}")
	@NotEmpty(message = "{error.tenure.data}")
	private String tenure;

	@Min(value = 1, message = "{error.interest.negative}")
	@NotEmpty(message = "{error.interest.data}")
	private String interest;

	@NotEmpty(message = "{error.collateralType.data}")
	private String collateralType;

	@NotEmpty(message = "{error.detail.data}")
	private String detail;

	@Min(value = 1, message = "{error.currentvalue.negative}")
	@NotEmpty(message = "{error.currentvalue.data}")
	private String currentvalue;

	@Min(value = 1, message = "{error.detail.negative}")
	@NotEmpty(message = "{error.detail.data}")
	private String detail1;

	@Min(value = 1, message = "{error.detail.negative}")
	@NotEmpty(message = "{error.detail.data}")
	private String detail2;

	@NotEmpty(message = "{error.custname.data}")
	private String custname;

	@NotEmpty(message = "{error.custaddress.data}")
	private String custaddress;

	@Min(value = 1, message = "{error.custphoneNo.negative}")
	@NotEmpty(message = "{error.custphoneNo.data}")
	private String custphoneNo;
}