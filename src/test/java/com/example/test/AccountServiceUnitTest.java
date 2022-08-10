package com.example.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.persistence.domain.Account;
import com.example.persistence.repository.AccountRepository;
import com.example.rest.dto.AccountDto;
import com.example.service.AccountService;

@SpringBootTest
public class AccountServiceUnitTest
{
	@Autowired
	private AccountService service;
		
	@MockBean
	private AccountRepository repo;

	
	final Account SAVED_ACCOUNT = new Account(1L, "Rewards", "93268277", "8282864620180142", "5017", 50.17, null);
	
	@Test
	void testCreate() throws Exception
	{
		final Account TEST_ACCOUNT = new Account(null, "Rewards", "93268277", "8282864620180142", "5017", 50.17, null);
		
		given(this.repo.save(TEST_ACCOUNT)).willReturn(TEST_ACCOUNT);
		
		AccountDto saveDto = this.service.addAccount(TEST_ACCOUNT);
		
		assertThat(saveDto).usingRecursiveComparison().isEqualTo(TEST_ACCOUNT);
	}

	@Test
	void testUpdateAccount()
	{
		given(repo.save(any(Account.class))).willReturn(SAVED_ACCOUNT);
		
		Account SAVED_Account = repo.save(SAVED_ACCOUNT);
		
		assertThat(SAVED_Account.getAccountNumber()).isNotNull();
	}
	
	@Test
	void testFindAll()
	{
		List<Account> Accounts = new ArrayList<>();
		Accounts.add(SAVED_ACCOUNT);
		Accounts.add(new Account (2L, "LISA", "28304719", "8801422186428620", "0192", 20730.12, null));
		Accounts.add(new Account (3L, "Cash ISA", "94725482", "8641420828262018", "1997", 3054.76, null));
		
		given(repo.findAll()).willReturn(Accounts);
		
		List<AccountDto> expected = service.readAccount();
		
		assertThat(expected).usingRecursiveComparison().isEqualTo(Accounts);
	}
	
	@Test
	void testFindById()
	{
		final Long id = 1L;
		final Account TEST_Account_ID = new Account();
		
		given(repo.findById(id)).willReturn(Optional.of(TEST_Account_ID));
		
		final AccountDto expected = service.findById(id);
		
		assertThat(expected).isNotNull();
	}
	
	@Test
	void testDeletion()
	{
		final Long id = 1L;
		
		service.deleteAccount(id);
		service.deleteAccount(id);
		
		verify(repo, times(2)).deleteById(id);
	}
}
