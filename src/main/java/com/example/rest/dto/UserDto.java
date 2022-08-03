package com.example.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto //password and address not mapped in responses
{
	private String userName;
	private String firstName;
	private String surname;
	private String email;
	private String phone;

//	------------------constructors------------------
//Lombok used
	

}
