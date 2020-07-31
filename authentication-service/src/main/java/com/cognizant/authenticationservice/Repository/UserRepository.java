package com.cognizant.authenticationservice.Repository;

import com.cognizant.authenticationservice.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String>{

	User findByEmailId(String emailId);


    
}