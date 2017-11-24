package com.ingenico.controller;

import java.math.BigDecimal;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import com.ingenico.model.Account;

public class AccountControllerTest {
	
	public static final String ENDPOINT="http://localhost:8081/ingenico/account/";

	@Test
	public void createAccount() {

		RestTemplate restTemplate = new RestTemplate();
		Account account = new Account();
		account.setBalance(new BigDecimal(300));
		account.setCustName("newCustomer");
		account.setIban("NewIBAN");

		URI uri = restTemplate.postForLocation(ENDPOINT+"create/", account,
				Account.class);
	}
	
	@Test
	public void deleteAccount() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(ENDPOINT+"delete/IBAN3");
	}

	@Test
	public void getAllAccountDetails() {
		
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> acccountMap = restTemplate.getForObject(ENDPOINT+"allaccount/", List.class);
	}

	
}
