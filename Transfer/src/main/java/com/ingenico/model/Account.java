package com.ingenico.model;

import java.math.BigDecimal;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

public class Account {

	@NotBlank(message="IBAN cannot be blank")
	@Pattern(regexp = "^[a-zA-Z]+",message="Please eneter only alpabets in the name")
	private String iban;
	
	@NotBlank(message="Customer Name cannot be blank")
	@Pattern(regexp = "^[a-zA-Z]+",message="Please eneter only alpabets in the name")
	private String custName;
	
	@NumberFormat
	private BigDecimal balance;

	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}	
}
