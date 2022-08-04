package com.example.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.persistence.domain.Account;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto //password and address not mapped in responses
{
	private String username;
	private String firstName;
	private String surname;
	private String email;
	private String phone;
	private List<Account> account = new ArrayList<>();
}
