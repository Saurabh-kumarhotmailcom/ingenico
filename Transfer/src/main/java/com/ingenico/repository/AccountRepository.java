package com.ingenico.repository;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.ingenico.dto.AccountDTO;

@Repository
public interface AccountRepository extends JpaRepository<AccountDTO, String>{
	
	@Override
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	AccountDTO findOne(String arg0);
}
