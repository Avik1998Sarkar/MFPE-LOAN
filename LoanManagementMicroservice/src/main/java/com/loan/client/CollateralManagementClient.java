package com.loan.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.loan.pojo.DataCollateralLoan;

@FeignClient(url = "${collateral.url}", name = "${collateral.name}")
public interface CollateralManagementClient {

	@RequestMapping(path = "/getCollaterals/{loanid}", method = RequestMethod.GET)
	public DataCollateralLoan getCollateralByLoanId(@RequestHeader(name = "Authorization") String token,
			@PathVariable int loanid);
	
	@RequestMapping(path = "/saveCollateral", method = RequestMethod.POST)
	public String saveCollateral(@RequestHeader(name = "Authorization") String token,
			@RequestBody DataCollateralLoan collateralLoan);
}
