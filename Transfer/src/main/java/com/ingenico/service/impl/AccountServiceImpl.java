package com.ingenico.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;
import com.ingenico.dto.AccountDTO;
import com.ingenico.exception.TransferServiceException;
import com.ingenico.model.Account;
import com.ingenico.repository.AccountRepository;
import com.ingenico.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	/* (non-Javadoc)
	 * @see com.ingenico.service.AccountService#createAccount(com.ingenico.model.Account)
	 */
	@Override
	public Account createAccount(Account account) {
		AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);
		accountDTO=accountRepository.save(accountDTO);
		return account;
	}

	/* (non-Javadoc)
	 * @see com.ingenico.service.AccountService#deleteAccountByIban(java.lang.String)
	 */
	@Override
	public void deleteAccountByIban(String iban) {
		try{
			accountRepository.delete(iban);
		}catch(EmptyResultDataAccessException e) {
			throw new TransferServiceException("IBAN does not exist!!!");
		}
	}

	/* (non-Javadoc)
	 * @see com.ingenico.service.AccountService#getAllAccountDetails()
	 */
	@Override
	public List<Account> getAllAccountDetails() {
		List<AccountDTO> listAccountDTO=accountRepository.findAll();
	    java.lang.reflect.Type targetListType = new TypeToken<List<Account>>() {}.getType();
	    List<Account> listAccount = modelMapper.map(listAccountDTO, targetListType);
		return listAccount;
	}

}
