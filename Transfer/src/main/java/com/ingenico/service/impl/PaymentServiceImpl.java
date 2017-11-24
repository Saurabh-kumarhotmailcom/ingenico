package com.ingenico.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.transaction.Transactional;

import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingenico.config.Constants;
import com.ingenico.dto.AccountDTO;
import com.ingenico.dto.TransferDTO;
import com.ingenico.exception.InsufficientBalanceException;
import com.ingenico.exception.TransferServiceException;
import com.ingenico.model.Transfer;
import com.ingenico.repository.AccountRepository;
import com.ingenico.repository.TransferRepository;
import com.ingenico.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	TransferRepository 	transferRepository;
	
	@Autowired
	AccountRepository accountRepository; 
	
	/* (non-Javadoc)
	 * @see com.ingenico.service.TransferService#transfer(com.ingenico.model.Transfer)
	 */
	@Override
	@Transactional
	public void transfer(Transfer transfer) {
		AccountDTO credAccount=accountRepository.findOne(transfer.getCredtIBAN());
		AccountDTO debtAccount=accountRepository.findOne(transfer.getDebitIBAN());
		
		if(debtAccount == null) {
			throw new TransferServiceException("Debitor IBAN does not exists"+transfer.getDebitIBAN());
		}
		
		if(credAccount == null) {
			throw new TransferServiceException("Creditor IBAN does not exists"+transfer.getCredtIBAN());
		}
		
		
		BigDecimal dbtBalance=debtAccount.getBalance().subtract(transfer.getAmount());
		
		if(dbtBalance.compareTo(Constants.minimumBalance) < 0) {
			throw new InsufficientBalanceException();
		}
		
		BigDecimal cdtBalance=debtAccount.getBalance().add(transfer.getAmount());
		debtAccount.setBalance(dbtBalance);
		credAccount.setBalance(cdtBalance);
		accountRepository.save(debtAccount);
		accountRepository.save(credAccount);
		
		TransferDTO transferDTO = new TransferDTO();
		transferDTO.setAmount(transfer.getAmount());
		transferDTO.setCrdtAccount(credAccount);
		transferDTO.setDbitAccount(debtAccount);
		transferDTO.setTimeOfTxn(new Date());
		transferRepository.save(transferDTO);
	}

}