package com.demojuin.demojuin.DTO;

import lombok.Data;

@Data
public class RegisterDto {
    private String firstname;
    private String lastName;
    private String username;
    private String email;
    private String pasword;
}
