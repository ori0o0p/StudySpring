package com.example.studyspring.domain.user.dto;

import com.example.studyspring.domain.user.dto.request.LoginRequest;
import com.example.studyspring.domain.user.dto.request.SignupRequest;
import com.example.studyspring.domain.user.dto.response.LoginResponse;
import com.example.studyspring.domain.user.service.LoginService;
import com.example.studyspring.domain.user.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    private final SignupService signupService;
    private final LoginService loginService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequest request) {
        signupService.execute(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginService.execute(request);
    }

}
