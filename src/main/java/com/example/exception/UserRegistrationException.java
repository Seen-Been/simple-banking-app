package com.example.exception;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//POSTing a duplicate email is a conflict with "the current state of the resource" as a collection. Add link to resolve the issue
@ResponseStatus(code = HttpStatus.CONFLICT, reason = "This email address is already registered.")
public class UserRegistrationException extends SQLException
{
	private static final long serialVersionUID = 1L;
}
