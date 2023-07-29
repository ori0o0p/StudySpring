package com.example.studyspring.domain.user.service;

import com.example.studyspring.domain.user.Exception.AlreadyExistException;
import com.example.studyspring.domain.user.dto.request.SignupRequest;
import com.example.studyspring.domain.user.entity.User;
import com.example.studyspring.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public void execute(SignupRequest request) {
        if (userRepository.findByAccountId(request.getAccountId()).isPresent() ||
                userRepository.findByEmail(request.getEmail()).isPresent()) {
            log.error(" 회원가입 실패 ");
            throw AlreadyExistException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .accountId(request.getAccountId())
                .name(request.getName())
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .build());
    }

}
