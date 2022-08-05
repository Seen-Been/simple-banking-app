package com.example.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.persistence.domain.Account;
import com.example.persistence.repository.AccountRepository;
import com.example.service.AccountService;

@SpringBootTest
public class AccountServiceUnitTest
{
	@Autowired
	private AccountService service;
		
	@MockBean
	private AccountRepository repo;
		
	@Test
	void testCreate()
	{
		final Account TEST_ACCOUNT = new Account();
		final Account TEST_SAVED_ACCOUNT = new Account();

		Mockito.when(this.repo.save(TEST_ACCOUNT)).thenReturn(TEST_SAVED_ACCOUNT);
		Assertions.assertThat(this.service.addAccount(TEST_ACCOUNT)).isEqualTo(TEST_SAVED_ACCOUNT);
	}
}
