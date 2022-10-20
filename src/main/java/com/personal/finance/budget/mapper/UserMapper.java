package com.personal.finance.budget.mapper;

import com.personal.finance.budget.controller.request.UserRequest;
import com.personal.finance.budget.controller.response.UserResponse;
import com.personal.finance.budget.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "enabled", expression = "java(Boolean.TRUE)")
    User toUser(UserRequest request);

    UserResponse toUserResponse(User user);

}

