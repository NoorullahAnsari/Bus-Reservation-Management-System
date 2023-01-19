/*
@Noorullah Ansari
Reservation Table and Cancellation Table
DDL **************/
drop database if exists brms;
create database brms ;
use brms;
show tables;
drop table if exists cancellation ;
create table cancellation(
user_id varchar(20),
bus_id varchar(20),
ticket_id varchar(12) not null,
booking_status varchar(20),
booked_date date,
curr_date date,
booked_charge float,
refund_amt float,
reas_of_Cancel varchar(20),
primary key(ticket_id) 
);
desc table cancellation;