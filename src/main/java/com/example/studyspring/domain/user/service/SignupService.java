package com.example.studyspring.domain.user.service;

import com.example.studyspring.domain.user.Exception.AlreadyExistException;
import com.example.studyspring.domain.user.dto.request.SignupRequest;
import com.example.studyspring.domain.user.entity.User;
import com.example.studyspring.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;

    public void execute(SignupRequest request) {
        if (userRepository.findByAccountId(request.getAccountId()).isPresent() ||
                userRepository.findByEmail(request.getEmail()).isPresent()) {
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
