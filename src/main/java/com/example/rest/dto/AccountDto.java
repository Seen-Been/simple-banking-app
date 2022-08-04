package com.example.rest.dto;

import javax.persistence.Column;

import com.example.persistence.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDto
{
	private String accountType;
	private String accountNumber;
	@Column(scale = 2)
	private double balance;
	private User user;
}
