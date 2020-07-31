package com.cognizant.authenticationservice.Controller;

import javax.validation.Valid;
import com.cognizant.authenticationservice.Exceptions.UserAlreadyExistsException;
import com.cognizant.authenticationservice.Model.User;
import com.cognizant.authenticationservice.Service.SignupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SignupController {

    @Autowired
    SignupService signupService;

    @PostMapping("/signup")
    public String signup(@Valid @RequestBody User user) throws UserAlreadyExistsException, InterruptedException {
        return signupService.signup(user);
    }

}