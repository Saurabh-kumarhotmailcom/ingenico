package com.ingenico.service;

import com.ingenico.model.Transfer;

/**
 * The Interface TransferService.
 */
public interface PaymentService {
	
	/**
	 * Transfer.
	 *
	 * @param transfer the transfer
	 */
	void transfer(Transfer transfer);
}
