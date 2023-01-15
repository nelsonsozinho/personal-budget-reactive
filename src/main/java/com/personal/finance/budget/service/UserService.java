package com.personal.finance.budget.service;

import com.personal.finance.budget.config.security.JwtUtils;
import com.personal.finance.budget.config.security.PBKDF2Encoder;
import com.personal.finance.budget.controller.request.UserRequest;
import com.personal.finance.budget.controller.response.UserResponse;
import com.personal.finance.budget.exceptions.ResourceNotFoundException;
import com.personal.finance.budget.mapper.UserMapper;
import com.personal.finance.budget.model.User;
import com.personal.finance.budget.model.enumerator.Role;
import com.personal.finance.budget.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PBKDF2Encoder encoder;

    private JwtUtils jwtUtils;

    public Mono<UserResponse> save(UserRequest userRequest) {
        userRequest.setPassword(encoder.encode(userRequest.getPassword()));
        userRequest.setRoles(Strings.isBlank(userRequest.getRoles()) ? Role.ROLE_USER.name() : userRequest.getRoles());
        return userRepository.findByEmail(userRequest.getEmail())
                .flatMap(__ -> Mono.error(new ResourceNotFoundException("User is already registered")))
                .switchIfEmpty(Mono.defer(() -> userRepository.save(userMapper.toUser(userRequest))))
                .cast(User.class)
                .map(userMapper::toUserResponse);
    }

    public Mono<Void> delete(String userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("User not found")))
                .flatMap(user -> userRepository.deleteById(user.getUserId().toString()));
    }

    public Mono<UserResponse> findById(String id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("User not found")))
                .map(userMapper::toUserResponse);
    }

    public Mono<UserResponse> reactiveFindByEmail(String email) {
        return userRepository.findByEmail(email)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("User not found")))
                .map(userMapper::toUserResponse);
    }

    public Mono<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Mono<User> finAuthUser(final String token) {
        return Mono.just(jwtUtils.getUsernameFromToken(token.substring(7)))
                        .flatMap(userRepository::findByEmail);
    }

}
