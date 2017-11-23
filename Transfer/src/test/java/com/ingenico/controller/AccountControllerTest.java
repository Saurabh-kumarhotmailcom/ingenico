package com.ingenico.controller;

import java.math.BigDecimal;
import java.net.URI;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import com.ingenico.model.Account;
import com.ingenico.model.Transfer;

public class AccountControllerTest {

	@Test
	public void createAccount() {

		System.out.println("Testing create Account API----------");
		RestTemplate restTemplate = new RestTemplate();
		Account account = new Account();
		account.setBalance(new BigDecimal(300));
		account.setCustName("newCustomer");
		account.setIban("NewIBAN");

		URI uri = restTemplate.postForLocation("http://localhost:8081/ingenico/accounts/create/", account,
				Account.class);
		System.out.println("Location : " + uri.toASCIIString());
	}

	@Test
	public void deleteAccount() {
		System.out.println("Testing delete Acount API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8081/ingenico/accounts/delete/IBAN3");
	}

	@Test
	public void transfer() {
		System.out.println("Transfer ...");
		Transfer t=new Transfer();
		t.setAmount(new BigDecimal(100));
		t.setCredtIBAN("IBAN2");
		t.setDebitIBAN("IBAN4");
		
		
		RestTemplate restTemplate = new RestTemplate();
		URI uri = restTemplate.postForLocation("http://localhost:8081/ingenico/payments/transfer/", t,
				Transfer.class);
		System.out.println("Location : " + uri.toASCIIString());
	}

}
