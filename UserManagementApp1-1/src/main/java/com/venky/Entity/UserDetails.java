package com.venky.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table
public class UserDetails {

	@GeneratedValue
	@Id
	@Column(name="USERID")
	private Integer userId;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="EMAIlID")
	private String emailId;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="PHNO")
	private String phNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="COUNTRY")
	private Integer Country;
	
	@Column(name="STATE")
	private Integer State;
	
	@Column(name="CITY")
	private Integer City;
	
	@Column(name="ACCOUNTSTATUS")
	private String AccountStatus;


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	

	public Integer getCountry() {
		return Country;
	}

	public void setCountry(Integer country) {
		Country = country;
	}

	public Integer getState() {
		return State;
	}

	public void setState(Integer state) {
		State = state;
	}

	public Integer getCity() {
		return City;
	}

	public void setCity(Integer city) {
		City = city;
	}

	public String getAccountStatus() {
		return AccountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		AccountStatus = accountStatus;
	}
	
	
}
