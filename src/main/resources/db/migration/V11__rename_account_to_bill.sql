alter table if exists public.account rename to bill;
alter table if exists public.bill rename column account_id to bill_id;
alter table if exists public.payment rename column account_id to bill_id;

alter table if exists public.payment drop constraint account_account_id_fk;
alter table if exists public.payment add constraint bill_bill_id_fk foreign key (bill_id) references public.bill (bill_id);

alter table public.account_cost_center rename column account_id to bill_id;
alter table public.account_cost_center drop constraint account_cost_center_account_fk;
alter table public.account_cost_center rename constraint account_cost_center_cost_center_fk to bill_cost_center_cost_center_fk;
alter table public.account_cost_center rename to bill_cost_center;
alter table public.bill_cost_center add constraint bill_cost_center_account_fk foreign key (bill_id) references public.bill;