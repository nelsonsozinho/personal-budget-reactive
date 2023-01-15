alter table budget_user
    add account_non_expired boolean,
    add account_non_locked boolean,
    add credentials_not_expired boolean,
    add roles varchar(50);