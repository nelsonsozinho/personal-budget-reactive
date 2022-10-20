package com.personal.finance.budget.model;

import com.personal.finance.budget.model.enumerator.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Data
@Table("budget_user")
public class User {

    @Id
    @Column("user_id")
    private UUID userId;

    private String name;

    private String email;

    private String password;

    private Boolean enabled;

    private List<Role> roles;

}
