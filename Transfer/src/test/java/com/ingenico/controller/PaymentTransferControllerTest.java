package com.ingenico.controller;

import java.math.BigDecimal;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import com.ingenico.model.Account;
import com.ingenico.model.Transfer;

public class PaymentTransferControllerTest {

	public static final String ENDPOINT="http://localhost:8081/banking/payment";
	
	@Test
	public void transfer() {
		Transfer t=new Transfer();
		t.setAmount(new BigDecimal(100));
		t.setCredtIBAN("IBAN2");
		t.setDebitIBAN("IBAN4");
		
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForLocation(ENDPOINT+"/transfer/", t,Transfer.class);
	}
	
}
