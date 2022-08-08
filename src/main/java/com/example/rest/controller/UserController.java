package com.example.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.UserRegistrationException;
import com.example.persistence.domain.User;
import com.example.rest.dto.UserDto;
import com.example.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController
{
	@Autowired
	private UserService uService;

	public UserController(UserService uService)
	{
		super();
		this.uService = uService;
	}
	
//	------------------Postman------------------
	
	// CREATE USER DTO
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserDto create(@RequestBody User user)
	{
		return this.uService.addUser(user);
	}
	
	// READ ALL
	@GetMapping("/read")
	public List<UserDto> readAll()
	{
		return this.uService.readUser();
	}

	// READ BY NAME
	@GetMapping("/readname/{firstName}/{surname}")
	public UserDto readByName(@PathVariable String firstName, @PathVariable String surname)
	{
		return this.uService.findByName(firstName, surname);
	}

	// READ BY ID
	@GetMapping("/readid/{id}")
	public UserDto readById(@PathVariable long id)
	{
		return this.uService.findById(id);
	}
	
	// READ BY EMAIL
	@GetMapping("/reademail/{email}")
	public UserDto readByEmail(@PathVariable String email)
	{
		return this.uService.findByEmail(email);
	}
		
	// UPDATE USER
	@PutMapping("/update/{id}")
	public UserDto update(@PathVariable long id,@RequestBody User user)
	{
		return this.uService.updateUser(id, user);
	}

	// DELETE USER
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id)
	{
		this.uService.deleteUser(id);
	}
	// LOGIN SERVICE
	@GetMapping("/login/{username}/{password}")
	public int login(@PathVariable String username, @PathVariable String password)
	{
		return this.uService.checkDetails(username, password);
	}
}
