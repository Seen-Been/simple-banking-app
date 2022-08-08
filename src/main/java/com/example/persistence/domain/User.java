package com.example.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique=true)
	@NotNull
	@Size(min = 4, max = 16, message = "Username must be betweeen four and sixteen characters long.")
	private String username;
	
	@Size(min = 5, max = 20, message = "Password must be between 5 and 20 characters long.")
	private String password;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String surname;
	
	@Column(unique=true)
	@Email(message = "Please enter a valid email. Email addresses must contain an '@' and a '.'.")
	private String email;
	
	@Column(unique=true, length = 11)
	private String phone;
	
	private String house;
	
	private String street;
	
	@Size(min = 5, max = 7, message = "Please enter a valid postcode")
	private String postcode;
	
	private String county;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private List<Account> account = new ArrayList<>();
	
	@Min(value = 0)
	@Max(value = 2)
	private int access; // 0 = admin, 1 = operator, 2 = customer


	
}
