package com.ingenico.controller;


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

import com.ingenico.model.Account;
import com.ingenico.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/create/", method = RequestMethod.POST)
	public ResponseEntity<?> createAccount(@RequestBody Account account, UriComponentsBuilder ucBuilder) {
		account = accountService.createAccount(account);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/accounts/create/{iban}").buildAndExpand(account.getIban()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/delete/{iban}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAccount(@PathVariable("iban") String iban) {
		accountService.deleteAccountByIban(iban);
		return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
	}
}
