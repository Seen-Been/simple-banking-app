package com.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.persistence.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceIntegrationTest
{
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private final User TEST_USER = new User(1L, "SeenBeen", "pass123", "Sean", "Heathcote", "sean@gmail.com", "91729384938", "5",
			"New Street", "M34RNB", "Greater Manchester", null, 0);
	
	@Test
	public void testCreateUser() throws Exception
	{
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/user/create");
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(this.objectMapper.writeValueAsString(TEST_USER));
		mockRequest.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		//ResultMatcher matchContent = MockMvcResultMatchers.content().json(this.objectMapper.writeValueAsString(CreateUserDto.class));
		
		this.mock
			.perform(mockRequest)
			.andExpect(matchStatus);
			//.andExpect(matchContent);
		
		
		
		
		
		
	}
}
