drop database if exists shop_0;
create database shop_0;
use shop_0;
create table if not exists shop_info_0
(
    shop_id   bigint(19) primary key,
    shop_name varchar(45) default null,
    account   varchar(45)
) engine = InnoDB
  default charset = utf8;

create table if not exists shop_info_1
(
    shop_id   bigint(19) primary key,
    shop_name varchar(45) default null,
    account   varchar(45)
) engine = InnoDB
  default charset = utf8;

drop database if exists shop_1;
create database shop_1;
use shop_1;
create table if not exists shop_info_0
(
    shop_id   bigint(19) primary key,
    shop_name varchar(45) default null,
    account   varchar(45)
) engine = InnoDB
  default charset = utf8;

create table if not exists shop_info_1
(
    shop_id   bigint(19) primary key,
    shop_name varchar(45) default null,
    account   varchar(45)
) engine = InnoDB
  default charset = utf8;
