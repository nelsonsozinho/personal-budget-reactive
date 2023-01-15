alter table public.account
    alter column value type money using value::money;

create table if not exists payment
(
    payment_id uuid default gen_random_uuid() not null constraint payment_pk primary key,
    description varchar(255),
    date date,
    value money not null,
    account_id uuid constraint account_account_id_fk references account
);