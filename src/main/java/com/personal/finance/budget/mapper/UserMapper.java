package com.personal.finance.budget.mapper;

import com.personal.finance.budget.controller.request.UserRequest;
import com.personal.finance.budget.controller.response.UserResponse;
import com.personal.finance.budget.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "enabled", expression = "java(java.lang.Boolean.TRUE)")
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "budget", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    @Mapping(target = "accountNonExpired", source="accountNonExpired", defaultValue = "true")
    @Mapping(target = "accountNonLocked", source="accountNonLocked", defaultValue = "true")
    @Mapping(target = "credentialsNotExpired", source="credentialsNotExpired", defaultValue = "true")
    @Mapping(target = "roles", source = "roles")
    User toUser(UserRequest request);

    UserResponse toUserResponse(User user);

}

