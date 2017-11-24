package com.ingenico.exception;

public class TransferServiceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7694495604552368080L;
	

	public TransferServiceException() {
		super();
	}

	public TransferServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public TransferServiceException(String message) {
		super(message);
	}
}
