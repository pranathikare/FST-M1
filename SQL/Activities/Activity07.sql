REM   Script: Activity07
REM   select from orders

select sum(purchase_amount) AS "Total sum" from orders;

select avg(purchase_amount) AS "Total sum" from orders;

select amx(purchase_amount) AS "Total sum" from orders;

select max(purchase_amount) AS "Total sum" from orders;

select min(purchase_amount) AS "Total sum" from orders;

select count(distinct purchase_amount) AS "Count" from orders;

select sum(purchase_amount) AS "Total sum" from orders;

select avg(purchase_amount) AS "Average" from orders;

select max(purchase_amount) AS "maximum" from orders;

select min(purchase_amount) AS "minimum" from orders;

select count(distinct purchase_amount) AS "Count" from orders;

