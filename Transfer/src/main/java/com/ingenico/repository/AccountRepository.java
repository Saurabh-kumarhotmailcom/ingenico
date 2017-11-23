package com.ingenico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingenico.dto.AccountDTO;

@Repository
public interface AccountRepository extends JpaRepository<AccountDTO, String>{
}
