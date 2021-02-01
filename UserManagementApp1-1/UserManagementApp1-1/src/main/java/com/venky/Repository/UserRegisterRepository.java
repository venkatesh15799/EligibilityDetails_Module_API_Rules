package com.venky.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venky.Entity.UserDetails;
@Repository
public interface UserRegisterRepository extends JpaRepository<UserDetails,Serializable> {

	UserDetails findByEmailId(String emailId);
	UserDetails findByEmailIdAndPassword(String emailId,String password);
	
}
