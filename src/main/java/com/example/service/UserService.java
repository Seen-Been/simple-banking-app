package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.UserNotFoundException;
import com.example.persistence.domain.Account;
import com.example.persistence.domain.User;
import com.example.persistence.repository.UserRepository;
import com.example.rest.dto.UserDto;

@Service
public class UserService
{
	@Autowired
	private UserRepository uRepo;
	@Autowired
	private ModelMapper mapper;

	private UserDto mapToDTO(User user)
	{
		return this.mapper.map(user, UserDto.class);
	}
	
//	------------------CRUD------------------
	
	// CREATE USER
	public UserDto addUser(User user)
	{
		User saved = this.uRepo.save(user);
		return this.mapToDTO(saved);
	}
	
	// READ ALL
	public List<UserDto> readUser()
	{
		return this.uRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	//UPDATE USER
	public UserDto updateUser(long id, User user)
	{
		Optional<User> tempUser = this.uRepo.findById(id);
		User existing = tempUser.get();
		existing.setFirstName(user.getFirstName());
		existing.setUsername(user.getUsername());
		existing.setHouse(user.getHouse());
		existing.setStreet(user.getStreet());
		existing.setPostcode(user.getPostcode());
		existing.setCounty(user.getCounty());
		existing.setEmail(user.getEmail());
		existing.setPhone(user.getPhone());
		User updated = this.uRepo.save(existing);
		return this.mapToDTO(updated);
	}
	
	//DELETE USER
	public boolean deleteUser(long id)
	{
		this.uRepo.deleteById(id);
		boolean exists = this.uRepo.existsById(id);
		return !exists;
	}
	
//	------------------Queries------------------
	
	// LOGIN USER/PASS FLAG
	public int checkDetails(String username, String password)
	{
		int flag = 0;
		if(!uRepo.login(username, password).isEmpty())
		{
			flag = 1;
			System.out.println("Inside " + flag);
			return flag;
		}
		System.out.println("out --" + flag);
		return flag;
	}

	// RETRIEVE USER BY NAME
	public List<User> findUserByName(String firstName, String surname)
	{
		return this.uRepo.findUserByName(firstName, surname);
	}
	
	// RETRIEVE USER BY ID
		public List<User> findUserById(long id)
		{
			return this.uRepo.findUserById(id);
		}
}
