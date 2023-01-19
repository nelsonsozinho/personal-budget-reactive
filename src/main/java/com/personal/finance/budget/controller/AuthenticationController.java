package com.personal.finance.budget.controller;

import com.personal.finance.budget.config.security.JwtUtils;
import com.personal.finance.budget.config.security.PBKDF2Encoder;
import com.personal.finance.budget.controller.request.AuthRequest;
import com.personal.finance.budget.controller.response.AuthResponse;
import com.personal.finance.budget.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@AllArgsConstructor
@RestController
public class AuthenticationController {

    private final JwtUtils jwtUtils;
    private final PBKDF2Encoder encoder;
    private final UserService userService;

    @PostMapping("/auth")
    public Mono<ResponseEntity<AuthResponse>> authenticate(@RequestBody AuthRequest request) {
        return userService.findByEmail(request.getEmail())
                .filter(userDetails -> encoder.encode(request.getPassword()).equals(userDetails.getPassword()))
                .map(userDetails ->
                        ResponseEntity.ok(AuthResponse.builder()
                                .token(jwtUtils.generateToken(userDetails))
                                .id(userDetails.getUserId())
                                .email(userDetails.getEmail())
                                .name(userDetails.getName())
                                .roles(Arrays.asList(userDetails.getRoles().split(" ")))
                                .build()))
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()));
    }

}
