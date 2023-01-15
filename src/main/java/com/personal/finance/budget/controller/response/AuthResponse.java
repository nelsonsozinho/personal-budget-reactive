package com.personal.finance.budget.controller.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Builder
@Data
public class AuthResponse {

    private UUID id;
    private String token;
    private String email;
    private String name;
    private List<String> roles;
}
