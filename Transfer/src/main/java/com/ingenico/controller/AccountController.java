package com.ingenico.controller;


import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ingenico.exception.TransferServiceException;
import com.ingenico.model.Account;
import com.ingenico.service.AccountService;


@RestController
@RequestMapping("/account")
public class AccountController {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(AccountController.class);

	/** The account service. */
	@Autowired
	AccountService accountService;

	/**
	 * Creates the account.
	 *
	 * @param account the account
	 * @param ucBuilder the uc builder
	 * @return the response entity
	 */
	@RequestMapping(value = "/create/", method = RequestMethod.POST)
	public ResponseEntity<?> createAccount(@RequestBody@Valid Account account, UriComponentsBuilder ucBuilder) {
		logger.debug("Create Account Started..");
		account = accountService.createAccount(account);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/accounts/create/{iban}").buildAndExpand(account.getIban()).toUri());
		logger.debug("Create Account Ended..");
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	/**
	 * Delete account.
	 *
	 * @param iban the iban
	 * @return the response entity
	 */
	@RequestMapping(value = "/delete/{iban}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAccount(@PathVariable("iban")@Pattern(regexp = "^[0-9a-zA-Z]+",message="Please enter proper IBAN") String iban) {
		logger.debug("Delete Account Started..");
		try {
			accountService.deleteAccountByIban(iban);
		}catch(TransferServiceException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		logger.debug("Delete Account Ended..");
		return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Gets the all account.
	 *
	 * @return the all account
	 */
	@RequestMapping(value = "/allaccount/", method = RequestMethod.GET)
	public ResponseEntity<List<Account>> getAllAccount() {
		logger.debug("Get All Account Started..");
		List<Account> listAccount=accountService.getAllAccountDetails();
		logger.debug("get All Account Ended..");
		return new ResponseEntity<List<Account>>(listAccount, HttpStatus.OK);
	}
}
