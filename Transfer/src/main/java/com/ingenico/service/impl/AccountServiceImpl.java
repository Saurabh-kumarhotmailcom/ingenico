package com.ingenico.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingenico.dto.AccountDTO;
import com.ingenico.model.Account;
import com.ingenico.repository.AccountRepository;
import com.ingenico.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Account createAccount(Account account) {
		AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);
		accountDTO=accountRepository.save(accountDTO);
		return account;
	}

	@Override
	public Account getAccountDetails(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccountByIban(String iban) {
		accountRepository.delete(iban);
	}

}
