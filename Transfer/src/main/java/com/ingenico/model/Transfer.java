package com.ingenico.model;

import java.math.BigDecimal;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

public class Transfer {
	@NotBlank(message="Creditor Iban is needed!")
	@Pattern(regexp = "^[0-9a-zA-Z]+",message="Please eneter proper IBAN")
	private String credtIBAN;
	
	@NotBlank(message="Debitor IBAn is needed!")
	@Pattern(regexp = "^[0-9a-zA-Z]+",message="Please enter proper IBAN")
	private String debitIBAN;
	
	@NumberFormat()
	private BigDecimal amount;
	
	public String getCredtIBAN() {
		return credtIBAN;
	}
	public void setCredtIBAN(String credtIBAN) {
		this.credtIBAN = credtIBAN;
	}
	public String getDebitIBAN() {
		return debitIBAN;
	}
	public void setDebitIBAN(String debitIBAN) {
		this.debitIBAN = debitIBAN;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}
