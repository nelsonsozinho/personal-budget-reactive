package com.personal.finance.budget.controller;

import com.personal.finance.budget.controller.request.UserRequest;
import com.personal.finance.budget.controller.response.UserResponse;
import com.personal.finance.budget.model.User;
import com.personal.finance.budget.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Mono<UserResponse> saveUser(@RequestBody UserRequest user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable("id") String userId) {
        return userService.findById(userId);
    }

    @GetMapping("/email/{email}")
    public Mono<User> getUserByEmail(@PathVariable("email") String email) {
        return userService.findByEmail(email);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable("id") String employeeId) {
        return  userService.delete(employeeId);
    }

}
