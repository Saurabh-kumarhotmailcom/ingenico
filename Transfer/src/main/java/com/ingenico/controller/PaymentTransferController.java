package com.ingenico.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ingenico.exception.InsufficientBalanceException;
import com.ingenico.exception.TransferServiceException;
import com.ingenico.model.Transfer;
import com.ingenico.service.PaymentService;

/**
 * The Class PaymentTransferController.
 */
@RestController
@RequestMapping("/payment")
public class PaymentTransferController {
	
	/** The payment service. */
	@Autowired
	PaymentService paymentService;
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(AccountController.class);
	
	/**
	 * Transfer.
	 *
	 * @param transfer the transfer
	 * @return the response entity
	 */
	@RequestMapping(value = "/transfer/", method = RequestMethod.POST)
	private ResponseEntity<?> transfer(@RequestBody@Valid Transfer transfer) {
		logger.debug("Transfer initiated");
		try{
			paymentService.transfer(transfer);
		}catch(InsufficientBalanceException ex) {
			logger.debug("Exception occured"+ex);
			return new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
		}catch(TransferServiceException ex) {
			logger.debug("Exception occured"+ex);
			return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
		}
		HttpHeaders headers = new HttpHeaders();
		logger.debug("Transfer ended");
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
}
