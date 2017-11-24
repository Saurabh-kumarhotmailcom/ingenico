package com.ingenico.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;

import com.ingenico.dto.AccountDTO;
import com.ingenico.exception.InsufficientBalanceException;
import com.ingenico.exception.TransferServiceException;
import com.ingenico.model.Transfer;
import com.ingenico.repository.AccountRepository;
import com.ingenico.repository.TransferRepository;


public class PaymentServiceImplTest {

	@Test
	public void testTransfer() {
		PaymentServiceImpl paymentServiceImpl=new PaymentServiceImpl();
		Transfer t=new Transfer();
		t.setAmount(new BigDecimal(100));
		t.setCredtIBAN("IBAN2");
		t.setDebitIBAN("IBAN4");
		
		TransferRepository 	transferRepository=mock(TransferRepository.class);
		paymentServiceImpl.setTransferRepository(transferRepository);
		AccountRepository accountRepository=mock(AccountRepository.class); 
		paymentServiceImpl.setAccountRepository(accountRepository);
		
		when(accountRepository.findOne(anyString())).thenReturn(null);
		
		try {
			paymentServiceImpl.transfer(t);
		}catch(TransferServiceException ex){
			assertEquals("Debitor IBAN does not exists IBAN4", ex.getMessage());
		}
		
		AccountDTO accountDTO=new AccountDTO();
		accountDTO.setBalance(new BigDecimal(100));
		accountDTO.setCustName("DEBIT");
		accountDTO.setIban("DEBITIBAN");
		when(accountRepository.findOne(anyString())).thenReturn(accountDTO);
		
		try {
			paymentServiceImpl.transfer(t);
		}catch(TransferServiceException ex){
			assert(ex instanceof InsufficientBalanceException);
		}
		
		
	}

}
