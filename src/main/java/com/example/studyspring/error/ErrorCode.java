package com.example.studyspring.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    ALREADY_EXIST(400, "user already exist"),
    PASSWORD_NOT_MATCHES(400, "incorrect password"),
    AUTH_CODE_NOT_MATCHES(400,"auth code not matched"),

    BOARD_NOT_FOUND(404,"board not found"),
    USER_NOT_FOUND(404, "user not found");

    private final int httpStatus;
    private final String message;
}