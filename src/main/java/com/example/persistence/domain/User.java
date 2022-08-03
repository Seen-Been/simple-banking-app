package com.example.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique=true)
	@NotNull
	@Size(min = 4, max = 16, message = "Username must be betweeen four and sixteen characters long.")
	private String username;
	
	@Size(min = 5, max = 20, message = "Password must be between 5 and 20 characters long.")
	private String password;
	
	private String firstName;
	private String surname;
	
	@Column(unique=true)
	@Email
	private String email;
	
	@Column(unique=true)
	private String phone;
	
	private String house;
	private String street;
	private String postcode;
	private String county;
	private Account accounts;
}
