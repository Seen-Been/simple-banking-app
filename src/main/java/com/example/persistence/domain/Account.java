package com.example.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String accountType;
	
	@Column(unique=true, length = 8)
	private String accountNumber;
	
	@Column(unique=true, length = 16)
	private String cardNumber;
	
	@Column(length = 16)
	private String pin;
	
	@Min(value = 0)
	@Column(scale = 2)
	private double balance;
	
	@ManyToOne(targetEntity = User.class)
	@JsonBackReference
	private User user;
}
