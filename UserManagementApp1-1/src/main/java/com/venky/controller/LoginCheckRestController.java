package com.venky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venky.Model.LoginCheck;
import com.venky.Service.UserService;

@RestController
public class LoginCheckRestController {

	@Autowired
	private UserService uService;
	
	@PostMapping("/login")
	public String loginCheck(@RequestBody LoginCheck loginCheck)
	{
			return uService.userLogin(loginCheck.getEmailId(), loginCheck.getPassword());
	}
}
