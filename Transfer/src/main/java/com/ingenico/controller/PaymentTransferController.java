package com.ingenico.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ingenico.model.Transfer;
import com.ingenico.service.TransferService;

/**
 * The Class PaymentTransferController.
 */
@RestController
@RequestMapping("/payment")
public class PaymentTransferController {
	
	/** The payment service. */
	@Autowired
	TransferService paymentService;
	
	/**
	 * Transfer.
	 *
	 * @param transfer the transfer
	 * @return the response entity
	 */
	@RequestMapping(value = "/transfer/", method = RequestMethod.POST)
	private ResponseEntity<?> transfer(@RequestBody@Valid Transfer transfer) {
		paymentService.transfer(transfer);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
}
