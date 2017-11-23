package com.ingenico.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DB_Transfer")
public class TransferDTO {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
		
	@Column(name="AMOUNT", nullable=false)
	private BigDecimal amount;
	
	@Column(name="TIMEOFTXN")
	private Date timeOfTxn;
	
	@ManyToOne
    @JoinColumn(name = "CREDITORIBAN")
	AccountDTO crdtAccount;
	
	@ManyToOne
    @JoinColumn(name = "DEBITORIBAN")
	AccountDTO dbitAccount;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	
	public Date getTimeOfTxn() {
		return timeOfTxn;
	}

	public void setTimeOfTxn(Date timeOfTxn) {
		this.timeOfTxn = timeOfTxn;
	}

	public AccountDTO getCrdtAccount() {
		return crdtAccount;
	}

	public void setCrdtAccount(AccountDTO crdtAccount) {
		this.crdtAccount = crdtAccount;
	}

	public AccountDTO getDbitAccount() {
		return dbitAccount;
	}

	public void setDbitAccount(AccountDTO dbitAccount) {
		this.dbitAccount = dbitAccount;
	}
	
	
}
