package com.example.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Account
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String accountType;
	@ManyToOne(targetEntity = User.class)
	private User user;
	
	@NotNull
	@Column(unique=true, length = 8)
	private String accountNumber;
	
	@Column(unique=true, length = 16)
	private String cardNumber;
	
	@Column(length = 16)
	private String pin;
	
	@Min(value = 0)
	@Column(scale = 2)
	private float balance;
}
