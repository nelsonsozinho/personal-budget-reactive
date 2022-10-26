alter table account
alter column value type decimal using value::decimal;

alter table account add description text;