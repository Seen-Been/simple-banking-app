package com.example.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User not found.")
public class UserNotFoundException extends EntityNotFoundException
{
	private static final long serialVersionUID = 1L;
}
