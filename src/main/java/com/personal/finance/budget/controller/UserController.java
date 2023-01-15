package com.personal.finance.budget.controller;

import com.personal.finance.budget.controller.request.UserRequest;
import com.personal.finance.budget.controller.response.UserResponse;
import com.personal.finance.budget.model.User;
import com.personal.finance.budget.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOG = LogManager.getLogger();

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<UserResponse> saveUser(@RequestBody UserRequest user) {
        LOG.info("Try to signing an user with email: [{}] ", user.getEmail());
        return userService.save(user)
                .doOnSuccess(cus -> LOG.info("User signing with success with email [{}]", user.getEmail()));
    }

    @GetMapping("/{id}")
    public Mono<UserResponse> getUser(@PathVariable("id") String userId) {
        return userService.findById(userId);
    }

    @GetMapping("/email/{email}")
    public Mono<UserResponse> getUserByEmail(@PathVariable("email") String email) {
        return userService.reactiveFindByEmail(email);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable("id") String employeeId) {
        return  userService.delete(employeeId);
    }

}
