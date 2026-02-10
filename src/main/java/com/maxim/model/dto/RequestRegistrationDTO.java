package com.maxim.model.dto;

import lombok.Data;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Data
public class RequestRegistrationDTO {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;

}
