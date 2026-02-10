package com.maxim.service;

import com.maxim.model.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    public UserResponse registration( String username,
                                      String password,
                                      String firstName,
                                      String lastName,
                                      String email,
                                      Integer age){
        System.out.println(username);
        System.out.println(password);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println(age);
        UserResponse userResponse = new UserResponse();
        userResponse.setFirstName(firstName);
        userResponse.setLastName(lastName);
        userResponse.setAge(age);
        userResponse.setEmail(email);
        return userResponse;
    }
}
