package com.venky.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venky.Entity.UserDetails;
import com.venky.Service.UserService;


@RestController
public class RegisterController {

	@Autowired
	UserService uService;
	
	@GetMapping("/countryList")
	public Map<Integer,String> findCountries()
	{
		return uService.findCountries();
		
	}
	
	@GetMapping("/statesList/{countryId}")
	public Map<Integer, String> getStates(@PathVariable Integer countryId)
	{
		 return uService.findStates(countryId);
	}
	
	@GetMapping("/citiesList/{stateId}")
	public Map<Integer,String> getCities(@PathVariable Integer stateId)
	{
		return uService.findCities(stateId);
	}
	
	@GetMapping("/emailIdUnique/{emailId}")
	public String getEmailUnique(@PathVariable String emailId)
	{
		if(uService.isEmailUnique(emailId))
		{
			return "UNIQUE";
		}
		else {
			return "DUPLICATE";
		}
	}
	
	@PostMapping(value="/registration",consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> userRegister(@RequestBody UserDetails uDetails)
	{
		if(uService.isEmailUnique(uDetails.getEmailId()))
		{
			uService.saveUser(uDetails);
			return new ResponseEntity<>("Registration Success",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Registration Failed",HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
