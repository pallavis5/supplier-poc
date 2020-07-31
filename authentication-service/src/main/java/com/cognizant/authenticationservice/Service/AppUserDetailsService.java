package com.cognizant.authenticationservice.Service;

import com.cognizant.authenticationservice.Model.AppUser;
import com.cognizant.authenticationservice.Model.User;
import com.cognizant.authenticationservice.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("Start");
		User user = userRepository.findByEmailId(username);
		log.debug("user:", user);
		if (user == null) {
			throw new UsernameNotFoundException("user not present");
		} else {
			AppUser appUser = new AppUser(user);
			log.debug("authorities:", appUser.getAuthorities());
			return appUser;
		}
	}

}
