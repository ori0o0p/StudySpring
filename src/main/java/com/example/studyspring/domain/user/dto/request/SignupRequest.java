package com.example.studyspring.domain.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class SignupRequest {

    private String name;
    private String accountId;
    private String password;
    private String email;

}
