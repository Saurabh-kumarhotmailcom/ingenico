package com.ingenico.model;

import java.math.BigDecimal;

public class Transfer {
	private String credtIBAN;
	private String debitIBAN;
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
