package com.venky.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.venky.Service.UserService;



@WebMvcTest(RegisterController.class)
public class RegisterControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	private UserService userService;
	
	@Test
	public Map<Integer,String> findCountries() throws Exception
	{
		
		Map<Integer,String> map=new HashMap<Integer,String>();
		map.put(101, "INDIA");
		map.put(102,"USA");
		map.put(103, "AUS");
		Iterator<Integer> iterator = map.keySet().iterator();
		while(iterator.hasNext())
		{
			Object keyNames=iterator.next();
			Object valueNames=map.get(keyNames);
		}
		//when(userService.findCountries()).thenReturn(valueNames);
		
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/findCountries");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(200, status);
		return null;
		
	}
}
