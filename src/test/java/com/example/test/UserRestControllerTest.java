package com.example.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.rest.controller.UserController;

@SpringBootTest
@RunWith(SpringRunner.class) //JUnit 4?
public class UserRestControllerTest 
{
	@Autowired
	private UserController controller;
	
	@Test
	public void controllerInitCorrectly() //Checks that REST controller has been initialised
	{
		assertThat(controller).isNotNull();
	}
}
