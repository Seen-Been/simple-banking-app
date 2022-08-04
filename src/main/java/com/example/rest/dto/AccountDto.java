package com.example.rest.dto;

import com.example.persistence.domain.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDto
{
	private String accountType;
	//private User user;
	private String accountNumber;
	private float balance;
}
