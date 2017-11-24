package com.ingenico.exception;

import com.ingenico.config.Constants;

public class InsufficientBalanceException extends TransferServiceException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6460788343357736862L;
	
	private String message="Account cannot hold balance lesser than minimum balance:"+Constants.MINIMUMBALANCE;

	public InsufficientBalanceException() {
		super();
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
