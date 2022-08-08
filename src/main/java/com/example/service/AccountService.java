package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.AccountNotFoundException;
import com.example.persistence.domain.Account;
import com.example.persistence.repository.AccountRepository;
import com.example.rest.dto.AccountDto;

@Service
public class AccountService
{
	@Autowired
	private AccountRepository repo;
	@Autowired
	private ModelMapper mapper;
	
	private AccountDto mapToDTO(Account account)
	{
		return this.mapper.map(account, AccountDto.class);
	}
	
//	------------------CRUD------------------
	
	// CREATE ACCOUNT DTO
	public AccountDto addAccount(Account account)
	{
		Account saved = this.repo.save(account);
		return this.mapToDTO(saved);
	}
	
	// READ ALL
	public List<AccountDto> readAccount()
	{
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	// UPDATE ACCOUNT
	public AccountDto updateAccount(Long accountId, Account account)
	{
		Optional<Account> tempAcc = this.repo.findById(accountId);
		
		Account existing = tempAcc.get();

		existing.setAccountType(account.getAccountType());
		existing.setCardNumber(account.getCardNumber());
		existing.setPin(account.getPin());
		existing.setBalance(account.getBalance());
			
		Account updated = this.repo.save(existing);
		
		return this.mapToDTO(updated);
	}
	// DELETE ACCOUNT
	public boolean deleteAccount(Long accountId)
	{
		this.repo.deleteById(accountId);
		boolean exists = this.repo.existsById(accountId);
		return !exists;
	}

//	------------------Queries------------------
	// FIND BY ID
	public AccountDto findById(Long id)
	{
		Account found = this.repo.findById(id).orElseThrow(AccountNotFoundException::new);
		return this.mapToDTO(found);
	}
	
	// FIND BY ACCOUNT NUMBER
	public AccountDto findByAccountNumber(String accountNumber)
	{
		return this.mapToDTO(repo.findByAccountNumber(accountNumber));
	}
}
