package com.personal.finance.budget.service;

import com.personal.finance.budget.controller.request.UserRequest;
import com.personal.finance.budget.controller.response.UserResponse;
import com.personal.finance.budget.mapper.UserMapper;
import com.personal.finance.budget.model.User;
import com.personal.finance.budget.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;


    public Mono<UserResponse> save(UserRequest userRequest) {
        return Mono.just(userMapper.toUser(userRequest))
                .flatMap(userRepository::save)
                .map(userMapper::toUserResponse);

    }

    public Mono<Void> delete(String userId) {
        return Mono.empty();
    }

    public Mono<User> findById(String id) {
        return userRepository.findById(id);
    }

    public Mono<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
