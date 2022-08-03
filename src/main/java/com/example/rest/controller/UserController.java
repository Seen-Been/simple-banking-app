package com.example.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistence.domain.User;
import com.example.rest.dto.UserDto;
import com.example.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController
{
	private UserService uService;

	public UserController(UserService uService)
	{
		super();
		this.uService = uService;
	}
//	------------------Postman------------------
	
	// CREATE USER
	@PostMapping("/create")
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
	public List<User> readByName(@PathVariable String firstName, @PathVariable String surname)
	{
		return this.uService.findUserByName(firstName, surname);
	}

	// READ BY ID
	@GetMapping("/readid/{id}")
	public List<User> readById(@PathVariable long id)
	{
		return this.uService.findUserById(id);
	}
		
	// UPDATE USER
	@PostMapping("/update/{id}")
	public UserDto update(@PathVariable long id,@RequestBody User user)
	{
		return this.uService.updateUser(id, user);
	}

	// DELETE USER
	@DeleteMapping("/delete/{user}")
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
