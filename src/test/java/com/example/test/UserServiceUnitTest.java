package com.example.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
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
	
	//@Autowired 
	private ModelMapper modelMapper;
	
	private UserDto mapToDTO(User user) {
        return this.modelMapper.map(user, UserDto.class);
    }
	
	@MockBean
	private UserRepository repo;
	
	@Test
	void testCreate()
	{
		final User TEST_USER = new User(null, "SeenBeen", "pass123", "Sean", "Heathcote", "sean@gmail.com", "91729384938", "5", "New Street", "M34RNB", "Greater Manchester", null, 0);
		final User TEST_SAVED_USER = new User(1L, "SeenBeen", "pass123", "Sean", "Heathcote", "sean@gmail.com", "91729384938", "5", "New Street", "M34RNB", "Greater Manchester", null, 0);
		
		//User saved = this.repo.save(TEST_USER);
		
		Mockito.when(this.repo.save(TEST_USER)).thenReturn(TEST_SAVED_USER);
		Assertions.assertThat(this.service.addUser(TEST_USER)).isEqualTo(TEST_SAVED_USER);
	}
}