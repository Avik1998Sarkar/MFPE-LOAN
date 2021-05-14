package com.portal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.portal.pojo.DataCollateralLoan;

@FeignClient(url="${loan.url}",name="${loan.name}")
public interface LoanClient {
	@RequestMapping(path = "/loan/getLoanDetails/{loanId}", method = RequestMethod.GET)
	public DataCollateralLoan getLoanDetails(@RequestHeader(name = "Authorization") String token,
			@PathVariable int loanId);

	@RequestMapping(path = "/loan/saveCollaterals", method = RequestMethod.POST)
	public String saveCollaterals(@RequestHeader(name = "Authorization") String token,
			@RequestBody DataCollateralLoan dataCollateralLoan);
}
