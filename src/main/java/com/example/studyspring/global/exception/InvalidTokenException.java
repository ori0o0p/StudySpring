package com.example.studyspring.global.exception;

import com.example.studyspring.global.error.CustomException;
import com.example.studyspring.global.error.ErrorCode;

public class InvalidTokenException extends CustomException {

    public static final CustomException EXCEPTION = new InvalidTokenException();
    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }



}
