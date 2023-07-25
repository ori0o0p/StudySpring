package com.example.studyspring.domain.user.Exception;

import com.example.studyspring.global.error.CustomException;
import com.example.studyspring.global.error.ErrorCode;

public class AlreadyExistException extends CustomException {

    public static final CustomException EXCEPTION = new AlreadyExistException();

    private AlreadyExistException() {
        super(ErrorCode.ALREADY_EXIST);
    }
}
