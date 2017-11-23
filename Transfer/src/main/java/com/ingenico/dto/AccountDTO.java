package com.ingenico.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DB_ACCOUNT")
public class AccountDTO {
	
	@Id
	@Column(name="IBAN", nullable=false)
	private String iban;
	
	@Column(name="CUSTNAME", nullable=false)
	private String custName;
	
	@Column(name="BALANCE", nullable=false)
	private BigDecimal balance;

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
