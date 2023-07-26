package com.example.studyspring.domain.user.dto.request;

import lombok.Getter;

@Getter
public class LoginRequest {

    private String accountId;
    private String password;

}
