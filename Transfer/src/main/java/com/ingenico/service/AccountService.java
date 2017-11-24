package com.ingenico.service;

import java.util.List;

import com.ingenico.model.Account;

public interface AccountService {
	Account createAccount(Account account);
	List<Account> getAllAccountDetails();
	void deleteAccountByIban(String iban);
}
