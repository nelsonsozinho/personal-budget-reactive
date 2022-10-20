package com.personal.finance.budget.controller;

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
    public Mono<User> saveEmployee(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public Mono<User> getEmployee(@PathVariable("id") String userId) {
        return userService.findById(userId);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteEmployee(@PathVariable("id") String employeeId) {
        return  userService.delete(employeeId);
    }

}
