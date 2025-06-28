package com.demojuin.demojuin.DTO;

import com.demojuin.demojuin.entities.UserEntity;
import lombok.Data;

@Data
public class AuthResponseDto {
    private String accessToken;
    private String tokenType = "Bearer";
    private UserEntity user;

    public AuthResponseDto(String accessToken, UserEntity user) {
        this.accessToken = accessToken;
        this.user = user;
    }
}
