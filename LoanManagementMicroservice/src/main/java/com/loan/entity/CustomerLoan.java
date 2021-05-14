package com.loan.entity;

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
@NoArgsConstructor
@ToString
@Entity
@Table(name = "customerloan")
public class CustomerLoan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_product_id")
	private int loanProductId;

	@Column(name = "loan_principal")
	private double loanPrincipal;

	@Column(name = "tenure")
	private double tenure;

	@Column(name = "interest")
	private double interest;

	@Column(name = "emi")
	private double emi;

	@OneToOne
	@JoinColumn(name = "loan_id")
	private Loan loan;
}
