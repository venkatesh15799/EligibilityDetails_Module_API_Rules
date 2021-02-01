package com.venky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venky.Service.UserService;

@RestController 
public class ForgotPasswordRestController {

	@Autowired
	UserService uService;
	
	@GetMapping("/forgotPwd")
	public String forgotPassword(@RequestParam String emailId )
	{
		return uService.forgotPassword(emailId);

	}
}
