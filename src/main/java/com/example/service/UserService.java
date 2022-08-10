package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.UserNotFoundException;
import com.example.persistence.domain.User;
import com.example.persistence.repository.UserRepository;
import com.example.rest.dto.UserDto;

@Service
public class UserService
{
	@Autowired
	private UserRepository repo;
	@Autowired
	private ModelMapper mapper;

	private UserDto mapToDTO(User user)
	{
		return this.mapper.map(user, UserDto.class);
	}
	
//	------------------CRUD------------------
	
	// CREATE USER DTO
	public UserDto addUser(User user)
	{
		User saved = this.repo.save(user);
		return this.mapToDTO(saved);
	}
	
	// READ ALL
	public List<UserDto> readUser()
	{
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	//UPDATE USER
	public UserDto updateUser(long id, User user)
	{
		Optional<User> tempUser = this.repo.findById(id);
		User existing = tempUser.get();
		existing.setFirstName(user.getFirstName());
		existing.setSurname(user.getSurname());
		existing.setUsername(user.getUsername());
		existing.setHouse(user.getHouse());
		existing.setStreet(user.getStreet());
		existing.setPostcode(user.getPostcode());
		existing.setCounty(user.getCounty());
		existing.setEmail(user.getEmail());
		existing.setPhone(user.getPhone());
		User updated = this.repo.save(existing);
		return this.mapToDTO(updated);
	}
	
	//DELETE USER
	public boolean deleteUser(long userId)
	{
		this.repo.deleteById(userId);
		boolean exists = this.repo.existsById(userId);
		return !exists;
	}
	
//	------------------Queries------------------
	
	// LOGIN USER/PASS FLAG
	public int checkDetails(String username, String password)
	{
		int flag = 0;
		if(!repo.login(username, password).isEmpty())
		{
			flag = 1;
			System.out.println("Inside " + flag);
			return flag;
		}
		System.out.println("out --" + flag);
		return flag;
	}
	
	// RETRIEVE USER BY NAME
	public UserDto findByName(String firstName, String surname)
	{
		return mapToDTO(repo.findUserByName(firstName, surname));
	}
	
	// RETRIEVE USER BY ID
	public UserDto findById(long id)
	{
		User found = this.repo.findById(id).orElseThrow(UserNotFoundException::new);
		return this.mapToDTO(found);
	}
	
	// RETRIEVE USER BY EMAIL
	public UserDto findByEmail(String email)
	{
		return mapToDTO(repo.findUserByEmail(email));
	}
}
