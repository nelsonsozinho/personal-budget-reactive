package com.personal.finance.budget.controller.request;

import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private String email;
    private String password;
    private Boolean enabled;
    private Boolean accountExpired;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNotExpired;
    private String roles;

}
