package com.ingenico.service;

import com.ingenico.model.Account;

public interface AccountService {
	Account createAccount(Account account);
	Account getAccountDetails(Account account);
	void deleteAccountByIban(String iban);
}
