package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.service.AccountService;

@SpringBootTest
public class AccountServiceUnitTest
{
	@Autowired
	private AccountService service;
}
