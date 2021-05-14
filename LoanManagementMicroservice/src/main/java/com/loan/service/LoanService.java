package com.loan.service;

import com.loan.exception.CollateralLoanAlreadyException;
import com.loan.exception.DataMissingException;
import com.loan.exception.NoCollateralLoanFoundException;
import com.loan.pojo.DataCollateralLoan;

public interface LoanService {
	public DataCollateralLoan getLoanDetails(int loanId, String token) throws NoCollateralLoanFoundException;

	public String saveCollaterals(DataCollateralLoan dataCollateralLoan, String token) throws DataMissingException, CollateralLoanAlreadyException;
}
