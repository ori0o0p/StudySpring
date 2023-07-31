package com.example.studyspring.domain.user.service;

import com.example.studyspring.domain.user.Exception.PasswordNotMatchedException;
import com.example.studyspring.domain.user.Exception.UserNotFoundException;
import com.example.studyspring.domain.user.dto.request.LoginRequest;
import com.example.studyspring.domain.user.dto.response.LoginResponse;
import com.example.studyspring.domain.user.entity.User;
import com.example.studyspring.domain.user.repository.UserRepository;
import com.example.studyspring.global.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;

    public LoginResponse execute(LoginRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordNotMatchedException.EXCEPTION;
        }

        String accessToken = jwtProvider.createAccessToken(request.getAccountId());
        String refreshToken = jwtProvider.createRefreshToken(request.getAccountId());

        return LoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }


}
