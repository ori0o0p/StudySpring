package com.example.studyspring.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    ALREADY_EXIST(400, "user already exist"),
    PASSWORD_NOT_MATCHES(400, "incorrect password"),

    INVALID_TOKEN(401, "유효하지 않은 토큰"),

    USER_NOT_FOUND(404, "user not found");

    private final int httpStatus;
    private final String message;
}