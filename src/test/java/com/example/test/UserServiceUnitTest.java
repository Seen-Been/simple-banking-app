package com.example.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.persistence.domain.User;
import com.example.persistence.repository.UserRepository;
import com.example.rest.dto.UserDto;
import com.example.service.UserService;

@SpringBootTest
public class UserServiceUnitTest
{
	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repo;
	
	final User TEST_SAVED_USER = new User(1L, "SeenBeen", "pass123", "Sean", "Heathcote", "sean@gmail.com", "91729384938", "5", "New Street", "M34RNB", "Greater Manchester", null, 0);
	
	@Test
	void testCreate() throws Exception
	{
		final User TEST_USER = new User(null, "SeenBeen", "pass123", "Sean", "Heathcote", "sean@gmail.com", "91729384938", "5", "New Street", "M34RNB", "Greater Manchester", null, 0);
		
		given(this.repo.save(TEST_USER)).willReturn(TEST_USER);
		
		UserDto saveDto = this.service.addUser(TEST_USER);
		
		assertThat(saveDto).usingRecursiveComparison().isEqualTo(TEST_USER);
	}

	@Test
	void testUpdateUser()
	{
		given(repo.save(any(User.class))).willReturn(TEST_SAVED_USER);
		
		User SAVED_USER = repo.save(TEST_SAVED_USER);
		
		assertThat(SAVED_USER.getFirstName()).isNotNull();
	}
	
	@Test
	void testFindAll()
	{
		List<User> users = new ArrayList<>();
		users.add(TEST_SAVED_USER);
		users.add(new User (2L, "jheystack", "pass123", "John", "Heystack", "jhey@aol.com", "91729381138", "21", "Old Street", "SK659LB", "Lancashire", null, 0));
		users.add(new User (3L, "chillberforce", "pass123", "Heimish", "Wilberforce", "chillber@force.com", "31729381138", "11", "Ten Street", "BL8917", "Merseyside", null, 0));
		
		given(repo.findAll()).willReturn(users);
		
		List<UserDto> expected = service.readUser();
		
		assertThat(expected).usingRecursiveComparison().isEqualTo(users);
	}
	
	@Test
	void testFindById()
	{
		final Long id = 1L;
		final User TEST_USER_ID = new User(1L, "jheystack", "pass123", "John", "Heystack", "jhey@aol.com", "91729381138", "21", "Old Street", "SK659LB", "Lancashire", null, 0);
		
		given(repo.findById(id)).willReturn(Optional.of(TEST_USER_ID));
		
		final UserDto expected = service.findById(id);
		
		assertThat(expected).isNotNull();
	}
	
	@Test
	void testDeletion()
	{
		final Long id = 1L;
		
		service.deleteUser(id);
		service.deleteUser(id);
		
		verify(repo, times(2)).deleteById(id);
	}
}
