drop database if exists `spring_bank_app_db`;
create database if not exists `spring_bank_app_db`;
use `spring_bank_app_db`;

drop table if exists `bank_account_details`;
create table if not exists `bank_account_details` (
    `account_id` int(10) not null auto_increment,
    `balance_amount` float not null,
    `last_transaction_ts` datetime not null,
    primary key (`account_id`)
    ) engine = InnoDB default charset = latin1 comment = 'Contains information about bank accounts of customers';

drop table if exists `fixed_deposit_details`;
create table if not exists `fixed_deposit_details` (
    `fixed_deposit_id` int(10) not null auto_increment,
    `account_id` int(10) not null,
    `fd_creation_date` date not null,
    `amount` int(10) not null,
    `tenure` int(10) not null,
    `active` char(1) not null default 'Y',
    primary key (`fixed_deposit_id`),
    key `FK_fixed_deposit_details_bank_account_details` (`account_id`),
    constraint `FK_fixed_deposit_details_bank_account_details` foreign key (`account_id`) references `bank_account_details` (`account_id`) on delete no action on update no action
    ) engine = InnoDB default charset = latin1;
