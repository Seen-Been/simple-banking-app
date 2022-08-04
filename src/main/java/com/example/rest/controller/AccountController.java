package com.example.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistence.domain.Account;
import com.example.rest.dto.AccountDto;
import com.example.service.AccountService;

@RestController
@RequestMapping(value = "/account")
public class AccountController
{
	@Autowired
	AccountService aService;

	public AccountController(AccountService aService)
	{
		super();
		this.aService = aService;
	}
	
//	------------------Postman------------------
	
	// CREATE USER
	@PostMapping("/create")
	public AccountDto create(@RequestBody Account account)
	{
		return this.aService.addAccount(account);
	}
	
	// READ ALL
	@GetMapping("/read")
	public List<AccountDto> readAll()
	{
		return this.aService.readAccount();
	}
	
	// READ BY ID
		@GetMapping("/readid/{id}")
		public AccountDto readById(@PathVariable long id)
		{
			return this.aService.findAccountById(id);
		}

	// UPDATE USER
	@PutMapping("/update/{id}")
	public AccountDto update(@PathVariable long id,@RequestBody Account account)
	{
		return this.aService.updateAccount(id, account);
	}
	
	// DELETE USER
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id)
	{
		this.aService.deleteUser(id);
	}
}
