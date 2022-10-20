package com.personal.finance.budget.service;

import com.personal.finance.budget.model.User;
import com.personal.finance.budget.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    public Mono<Void> delete(String userId) {
        return Mono.empty();
    }

    public Mono<User> findById(String id) {
        return userRepository.findById(id);
    }

    public Mono<User> findByEmail(String email) {
        return Mono.empty();
    }
}
