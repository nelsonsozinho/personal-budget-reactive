alter table public.payment
    alter column value type numeric using value::numeric;

alter table public.account
    alter column value type numeric using value::numeric;
