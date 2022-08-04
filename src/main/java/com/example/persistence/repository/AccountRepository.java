package com.example.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.persistence.domain.Account;

@Repository
@EnableJpaRepositories
public interface AccountRepository extends JpaRepository<Account, Long>
{
	//FIND BY ID
		@Query("select a from Account a where a.id =?1")
		List<Account> findAccountById(long id);
}
