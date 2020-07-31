package com.cognizant.authenticationservice.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * User
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "User")
public class User {

    @NotNull(message = "First Name is mandatory")
    @Size(min = 3, max = 30, message = "First Name should be atleast 3 characters")
    @Column(name = "FirstName")
    private String firstName;

    @NotNull(message = "Last Name is mandatory")
    @Size(min = 3, max = 30, message = " Last Name should be atleast 3 characters")
    @Column(name = "LastName")
    private String lastName;

    @NotNull(message = "Email is mandatory")
    @Email(message = "Follow email format")
    @Id
    @Column(name = "EmailId")
    private String emailId;

    @NotNull(message = "Password is mandatory")
    @Column(name = "Password")
    private String password;

    @NotNull(message = "Mobile Number is mandatory")
    @Column(name = "MobileNumber")
    private String mobileNumber;

    @NotNull(message = "User Type is mandatory")
    @Column(name = "UserType")
    private String userType;

}