package com.venky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venky.Model.UnlockAccount;
import com.venky.Service.UserService;

@RestController
public class UserUnlockRestController {

	@Autowired
	private UserService uService;
	
	@PostMapping("/unlockUserAccount")
	public String unlockUserAccount(@RequestBody UnlockAccount unlockAcc)
	{
		if(uService.checkUserTempPwd(unlockAcc.getEmailId(),unlockAcc.getTmpPwd())) {
		   uService.UnlockUserAccount(unlockAcc.getEmailId(), unlockAcc.getNewPwd());
			return "User is unlocked successfully,proceed to login";
		}
		return "user credentials failed!";
	}
}
