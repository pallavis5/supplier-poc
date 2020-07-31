package com.cognizant.authenticationservice.Service;

import com.cognizant.authenticationservice.Exceptions.UserAlreadyExistsException;
import com.cognizant.authenticationservice.Model.User;
import com.cognizant.authenticationservice.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SignupService
 */
@Service
@Slf4j
public class SignupService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    SupplierRequestService supplierRequestService;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String signup(User user) throws UserAlreadyExistsException, InterruptedException {

        if (userRepository.findByEmailId(user.getEmailId()) == null) { //signup for both customer and supplier onto user table
            String message = null;
            user.setPassword(encoder.encode(user.getPassword()));
            log.info("userType" + user.getUserType());
            if (user.getUserType().equals("supplier")) {
                log.info("exchange....");
                message = supplierRequestService.postSupplier(user.getEmailId()); //posts supplierId onto supplier table
                log.info("msg" + message);
            }

            if (message.equals("Post Success")) {
                userRepository.save(user);
                return "Signup Successful";
            } else {
                return message;
            }
        } else {
            throw new UserAlreadyExistsException();
        }

    }

}