package com.venky.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venky.Entity.City;
import com.venky.Entity.Country;
import com.venky.Entity.State;
import com.venky.Entity.UserDetails;
import com.venky.Repository.CityRepository;
import com.venky.Repository.CountryRepository;
import com.venky.Repository.StateRepository;
import com.venky.Repository.UserRegisterRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private CountryRepository countryRepo;

	@Autowired
	private StateRepository stateRepo;

	@Autowired
	private CityRepository cityRepo;

	@Autowired
	private UserRegisterRepository userRepo;

	@Autowired
	private EmailService emailSevice;
	@Override
	public Map<Integer, String> findCountries() {
		List<Country> countryList = countryRepo.findAll();
		Map<Integer, String> countries = new HashMap<>();
		countryList.forEach(country -> {
			countries.put(country.getCountryId(), country.getCountryName());
		});
		return countries;
	}

	@Override
	public Map<Integer, String> findStates(Integer countryId) {
		List<State> stateList = stateRepo.findByCountryId(countryId);
		Map<Integer, String> states = new HashMap<>();
		stateList.forEach(state -> {
			states.put(state.getStateId(), state.getStateName());
		});
		return states;
	}

	@Override
	public Map<Integer, String> findCities(Integer stateId) {

		List<City> cityList = cityRepo.findByStateId(stateId);
		Map<Integer, String> cities = new HashMap<>();
		cityList.forEach(city -> {
			cities.put(city.getCityId(), city.getCityName());
		});
		return cities;

	}

	@Override
	public boolean isEmailUnique(String emailId) {

		UserDetails details = userRepo.findByEmailId(emailId);
		if (details == null) {
			return true;

		} else {

			return false;
		}
	}

	@Override
	public boolean saveUser(UserDetails ud) {
		ud.setPassword(passwordGenerator());
		ud.setAccountStatus("Locked");
		UserDetails uDetails = userRepo.save(ud);
		String emailBody = getUnlockAcountEmail(uDetails);
		String subject="UNLOCK YOUR ACCOUNT | IES";
		boolean isSent = emailSevice.sendMail(uDetails.getEmailId(), subject, emailBody);
		
		return uDetails.getUserId() != null && isSent;
	}

	private String passwordGenerator() {
		char[] password = new char[10];
		String pwd = "ABCDEFGHIJKLabcdefghij1234566790";
		Random rd = new Random();
		for (int i = 0; i < 10; i++) {
			password[i] = pwd.charAt(rd.nextInt(pwd.length()));
		}
		/*
		 * char[] password=new char[6]; 
		 * String capital_ltr="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 * String small_ltr="abcdefghijklmnopqrstuvwxyz"; String numbers="1234567890";
		 * String values=capital_ltr+small_ltr+numbers; Random rdPwd=new Random();
		 * for(int i=0;i<6;i++) {
		 * password[i]=values.charAt(rdPwd.nextInt(values.length()); }
		 * System.out.println(password.toString());
		 */
		System.out.println(password.toString());
		return password.toString();
	}

	@Override
	public String userLogin(String emailId, String password) {
		UserDetails userDetails = userRepo.findByEmailIdAndPassword(emailId, password);
		if (userDetails != null) {
			if (userDetails.getAccountStatus().equals("LOCKED")) {
				return "User Locked State";
			} else {
				return "Login success";
			}
		}
		return "invalid credentials";
	}

	@Override
	public boolean checkUserTempPwd(String emailId, String tempPwd) {
		UserDetails uDetails = userRepo.findByEmailIdAndPassword(emailId, tempPwd);
		return uDetails.getUserId() != null;
	}

	@Override
	public boolean UnlockUserAccount(String emailId, String newPwd) {
		UserDetails details = userRepo.findByEmailId(emailId);
		details.setPassword(newPwd);
		details.setAccountStatus("UNLOCKED");
		try {
			userRepo.save(details);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String forgotPassword(String emailId) {
		UserDetails details = userRepo.findByEmailId(emailId);
		if (details != null) {
			return "Succussfully received your password ::"+details.getPassword();
		}
		else {
			return "please enter,valid email id";
			}
		
	}

	public String getUnlockAcountEmail(UserDetails uDetails) {
		
		StringBuffer sb = new StringBuffer("");
		String body=null;
		try {
			File f = new File("Unlock-Account-Email-Body.txt");
			/*
			  FileReader fr=new FileReader(f);
			 BufferedReader br=new BufferedReader(fr);
			 */
			BufferedReader br = new BufferedReader(
			        new InputStreamReader(new FileInputStream(f), "UTF8"));
			String Line = br.readLine();
			while (Line != null) {
				sb.append(Line);
				Line = br.readLine();
	
			}
			br.close();
			body=sb.toString();	
				body=body.replace("{FNAME}", uDetails.getFirstName());
				body=body.replace("{LNAME}", uDetails.getLastName());
				body=body.replace("{TEMP-PWD}", uDetails.getPassword());
				body=body.replace("{EMAIL}", uDetails.getEmailId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return body;
	}

}
