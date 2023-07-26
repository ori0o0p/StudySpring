package com.example.studyspring.domain.user.dto;

import com.example.studyspring.domain.user.dto.request.SignupRequest;
import com.example.studyspring.domain.user.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    private final SignupService signupService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequest request) {
        signupService.execute(request);
    }

}
