alter table budget_user
drop constraint budget_user_budget_id_fkey;

alter table budget_user
drop column budget_id;

alter table budget
    add user_id uuid;

alter table budget
    add constraint budget_budget_user_null_fk
        foreign key (user_id) references budget_user (user_id);
