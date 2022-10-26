create table if not exists account
(
    account_id uuid default gen_random_uuid() not null
    constraint account_id
    primary key,
    name       varchar(150) not null,
    value      money        not null,
    variable   boolean      not null
    );

create table if not exists budget
(
    name        varchar(150),
    description varchar(150),
    total       money not null,
    budget_id   uuid default gen_random_uuid() not null
    constraint budget_id
    primary key
    );

create table if not exists cost_center
(
    cost_center_id uuid default gen_random_uuid() not null
    constraint cost_center_pk
    primary key,
    name           varchar(150),
    description    varchar(150),
    budget_id      uuid
    constraint cost_center_budget_null_fk
    references budget
    );

create table if not exists account_cost_center
(
    account_id     uuid not null
    constraint account_cost_center_account_fk
    references account,
    cost_center_id uuid not null
    constraint account_cost_center_cost_center_fk
    references cost_center
);

alter table budget_user
    add budget_id uuid,
    ADD FOREIGN KEY (budget_id) REFERENCES budget(budget_id);

alter table budget_user
    owner to postgres;

alter table account_cost_center
    owner to postgres;

alter table budget
    owner to postgres;

alter table cost_center
    owner to postgres;

alter table account
    owner to postgres;



