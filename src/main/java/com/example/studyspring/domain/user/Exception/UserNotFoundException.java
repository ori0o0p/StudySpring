package com.example.studyspring.domain.user.Exception;

import com.example.studyspring.global.error.CustomException;
import com.example.studyspring.global.error.ErrorCode;

public class UserNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }


}
