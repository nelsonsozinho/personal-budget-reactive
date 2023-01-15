alter table public.payment
    alter column date type timestamp using date::timestamp;
