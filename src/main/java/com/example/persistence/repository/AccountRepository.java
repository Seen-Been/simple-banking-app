package com.example.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.persistence.domain.Account;

@Repository
@EnableJpaRepositories
public interface AccountRepository extends JpaRepository<Account, Long>
{
	
}
