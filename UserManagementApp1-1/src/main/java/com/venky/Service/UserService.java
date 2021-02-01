package com.venky.Service;

import java.util.Map;

import com.venky.Entity.UserDetails;

public interface UserService {

	
	//User registration
		public Map<Integer,String> findCountries();
		
		public Map<Integer,String> findStates(Integer countryId);
		
		public Map<Integer,String> findCities(Integer stateId);
		
		public boolean isEmailUnique(String emailId);
		
		public boolean saveUser(UserDetails ud);
		
	//login page
		//return as string,it will check credentials are valid and find account is locked or not
		public String userLogin(String emailId,String password);
		
		//unlocking account
		public boolean checkUserTempPwd(String emailId,String tempPwd);
		
		public boolean UnlockUserAccount(String emailId,String newPwd);
		
		//forgot password
		public String forgotPassword(String emailId);
}
