package com.personal.finance.budget.config.security;

import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.apache.commons.text.StringTokenizer;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AuthenticationManager implements ReactiveAuthenticationManager {

    private JwtUtils jwtUtil;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        final var authToken = authentication.getCredentials().toString();
        final var username = jwtUtil.getUsernameFromToken(authToken);
        return Mono.just(jwtUtil.validateToken(authToken))
                .filter(valid -> valid)
                .switchIfEmpty(Mono.empty())
                .map(valid -> {
                    final Claims claims = jwtUtil.getAllClaimsFromToken(authToken);
                    final List<String> rolesMap = rolesStringToList(claims.get("role", String.class));
                    return new UsernamePasswordAuthenticationToken(
                            username,
                            null,
                            rolesMap.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
                    );
                });
    }

    private List<String> rolesStringToList(String roles) {
        final StringTokenizer tokenizer = new StringTokenizer(roles, ";");
        final List<String> rolesList = new ArrayList<>();
        while(tokenizer.hasNext()) {
            rolesList.add(tokenizer.nextToken());
        }
        return rolesList;
    }

}
