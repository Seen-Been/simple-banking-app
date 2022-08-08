package com.example.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistence.domain.Account;
import com.example.rest.dto.AccountDto;
import com.example.service.AccountService;

@RestController
@RequestMapping(value = "/account")
public class AccountController
{
	@Autowired
	AccountService service;

	public AccountController(AccountService aService)
	{
		super();
		this.service = aService;
	}
	
//	------------------CRUD------------------
	
	// CREATE USER
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public AccountDto create(@RequestBody Account account)
	{
		return this.service.addAccount(account);
	}
	
	// READ ALL
	@GetMapping("/read")
	public List<AccountDto> readAll()
	{
		return this.service.readAccount();
	}
	
	// READ BY ID
	@GetMapping("/readid/{id}")
	public AccountDto readById(@PathVariable Long id)
	{
		return this.service.findById(id);
	}
	// READ BY ACCOUNT NUMBER
	@GetMapping("/readid/{accountNumber}")
	public AccountDto readByAccountNumber(@PathVariable String accountNumber)
	{
		return this.service.findByAccountNumber(accountNumber);
	}

	// UPDATE ACCOUNT
	@PutMapping("/update/{id}")
	public AccountDto update(@PathVariable Long id,@RequestBody Account account)
	{
		return this.service.updateAccount(id, account);
	}
	
	// DELETE ACCOUNT
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id)
	{
		this.service.deleteAccount(id);
	}
}
