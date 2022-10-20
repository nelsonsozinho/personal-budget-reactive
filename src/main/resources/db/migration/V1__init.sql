create table public."budget_user"
(
    name     varchar(200),
    email    varchar(200),
    password text,
    enabled  bool,
    user_id uuid default gen_random_uuid() PRIMARY KEY
);