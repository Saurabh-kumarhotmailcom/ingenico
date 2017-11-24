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

		System.out.println("Testing create Account API----------");
		RestTemplate restTemplate = new RestTemplate();
		Account account = new Account();
		account.setBalance(new BigDecimal(300));
		account.setCustName("newCustomer");
		account.setIban("NewIBAN");

		URI uri = restTemplate.postForLocation(ENDPOINT+"create/", account,
				Account.class);
		System.out.println("Location : " + uri.toASCIIString());
	}
	
	@Test
	public void deleteAccount() {
		System.out.println("Testing delete Acount API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(ENDPOINT+"delete/IBAN3");
	}

	@Test
	public void getAllAccountDetails() {
		System.out.println("All Account data ...");
		
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> acccountMap = restTemplate.getForObject(ENDPOINT+"allaccount/", List.class);
		System.out.println("ss"+acccountMap.size());
	}

	
}
