package com.example.studyspring.domain.user.Exception;

import com.example.studyspring.global.error.CustomException;
import com.example.studyspring.global.error.ErrorCode;

public class PasswordNotMatchedException extends CustomException {

    public static final CustomException EXCEPTION = new PasswordNotMatchedException();

    private PasswordNotMatchedException() {
        super(ErrorCode.PASSWORD_NOT_MATCHES);
    }
}
