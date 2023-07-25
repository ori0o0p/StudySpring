package com.example.studyspring.user.Exception;

import com.example.studyspring.error.CustomException;
import com.example.studyspring.error.ErrorCode;

public class AlreadyExistException extends CustomException {

    public static final CustomException EXCEPTION = new AlreadyExistException();

    private AlreadyExistException() {
        super(ErrorCode.ALREADY_EXIST);
    }
}
