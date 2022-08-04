package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.UserNotFoundException;
import com.example.persistence.domain.Account;
import com.example.persistence.domain.User;
import com.example.persistence.repository.AccountRepository;
import com.example.rest.dto.AccountDto;

@Service
public class AccountService
{
	@Autowired
	private AccountRepository aRepo;
	@Autowired
	private ModelMapper mapper;
	
	private AccountDto mapToDTO(Account account)
	{
		return this.mapper.map(account, AccountDto.class);
	}
	
//	------------------CRUD------------------
	
	// CREATE ACCOUNT
	public AccountDto addAccount(Account account)
	{
		Account saved = this.aRepo.save(account);
		return this.mapToDTO(saved);
	}
	
	// READ ALL
	public List<AccountDto> readAccount()
	{
		return this.aRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	// UPDATE ACCOUNT
	public AccountDto updateAccount(long accountId, Account account)
	{
		Optional<Account> tempUser = this.aRepo.findById(accountId);
		Account existing = tempUser.get();
		User user = new User();
			
		if (user.getAccess() == 0 || user.getAccess() == 1)	// 0 = admin, 1 = op, 2 = customer
		{
			existing.setAccountType(account.getAccountType());
			existing.setCardNumber(account.getCardNumber());
		}
		existing.setPin(account.getPin());
		existing.setBalance(account.getBalance());
			
		Account updated = this.aRepo.save(existing);
		return this.mapToDTO(updated);
	}
	// DELETE ACCOUNT
	public boolean deleteUser(long accountId)
	{
		this.aRepo.deleteById(accountId);
		boolean exists = this.aRepo.existsById(accountId);
		return !exists;
	}

	// FIND BY ID
	public AccountDto findAccountById(long id)
	{
		Account found = this.aRepo.findById(id).orElseThrow(UserNotFoundException::new);
		return this.mapToDTO(found);
	}
}
