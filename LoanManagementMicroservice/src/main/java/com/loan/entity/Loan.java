package com.loan.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "loan")
public class Loan {
	
	@Id
	@Column(name = "loan_id")
	private int id;
	@Column(name = "max_eligible")
	private int maximumLoanEligibilityAmount;
	@Column(name = "interest")
	private double interest;
	@Column(name = "tenure")
	private double tenure;
	
	@OneToOne(mappedBy = "loan", cascade = CascadeType.ALL)
	private CustomerLoan customerloan;
	
	@OneToOne(mappedBy = "loan", cascade = CascadeType.ALL)
	private Customer customer;
	
}
