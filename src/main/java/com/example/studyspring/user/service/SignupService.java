package com.example.studyspring.user.service;

import com.example.studyspring.user.Exception.AlreadyExistException;
import com.example.studyspring.user.dto.request.SignupRequest;
import com.example.studyspring.user.entity.User;
import com.example.studyspring.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;

    public void execute(SignupRequest request) {
        if (userRepository.findByAccountId(request.getAccountId()).isPresent()) {
            throw AlreadyExistException.EXCEPTION;
        }
        else if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw AlreadyExistException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .accountId(request.getAccountId())
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build());
    }

}
