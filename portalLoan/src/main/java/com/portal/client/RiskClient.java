package com.portal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.portal.pojo.DataCollateralRisk;

@FeignClient(url="${risk.url}",name="${risk.name}")
public interface RiskClient {

	@RequestMapping(path = "/risk/getCollateralRisk/{loanid}", method = RequestMethod.GET)
	public DataCollateralRisk getCollateralRiskByLoanId(@RequestHeader(name = "Authorization") String token,
			@PathVariable int loanid);

	@RequestMapping(path = "/risk/getCollateralRisk", method = RequestMethod.GET)
	public String updateCollateralMarketValue(@RequestHeader(name = "Authorization") String token);
}
