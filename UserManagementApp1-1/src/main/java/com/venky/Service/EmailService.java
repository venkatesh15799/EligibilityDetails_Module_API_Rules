package com.venky.Service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	JavaMailSender javaMailSender;
	
	public boolean sendMail(String to,String subject,String body)
	{
		try
		{
			MimeMessage message = javaMailSender.createMimeMessage();  
			  
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);  
	        helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body,true);
			javaMailSender.send(message);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
