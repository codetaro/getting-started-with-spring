drop database if exists securitydb;
create database if not exists securitydb;
use securitydb;

drop table if exists acl_class;
create table if not exists acl_class
(
    id    bigint(20)   not null auto_increment,
    class varchar(255) not null,
    primary key (id),
    unique key unique_uk_2 (class)
) engine = innodb auto_increment = 2 default charset = latin1;

insert into acl_class (id, class)
values (1, 'chapter14.bankapp.domain.FixedDepositDetails');

drop table if exists acl_sid;
create table if not exists acl_sid
(
    id        bigint(20)   not null auto_increment,
    principal tinyint(1)   not null,
    sid       varchar(100) not null,
    primary key (id),
    unique key unique_uk_1 (sid, principal)
) engine = innodb auto_increment = 5 default charset = latin1;

insert into acl_sid (id, principal, sid)
values (3, 1, 'admin'),
       (1, 1, 'cust1'),
       (2, 1, 'cust2');

drop table if exists acl_object_identity;
create table if not exists acl_object_identity
(
    id                 bigint(20) not null auto_increment,
    object_id_class    bigint(20) not null,
    object_id_identity bigint(20) not null,
    parent_object      bigint(20) default null,
    owner_sid          bigint(20) default null,
    entries_inheriting tinyint(1) not null,
    primary key (id),
    unique key unique_uk_3 (object_id_class, object_id_identity),
    key foreign_fk_1 (parent_object),
    key foreign_fk_3 (owner_sid),
    constraint foreign_fk_1 foreign key (parent_object) references acl_object_identity (id),
    constraint foreign_fk_2 foreign key (object_id_class) references acl_class (id),
    constraint foreign_fk_3 foreign key (owner_sid) references acl_sid (id)
) engine = innodb auto_increment = 12 default charset = latin1;

drop table if exists acl_entry;
create table if not exists acl_entry
(
    id                  bigint(20) not null auto_increment,
    acl_object_identity bigint(20) not null,
    ace_order           int(11)    not null,
    sid                 bigint(20) not null,
    mask                int(11)    not null,
    granting            tinyint(1) not null,
    audit_success       tinyint(1) not null,
    audit_failure       tinyint(1) not null,
    primary key (id),
    unique key unique_uk_4 (acl_object_identity, ace_order),
    key foreign_fk_5 (sid),
    constraint foreign_fk_4 foreign key (acl_object_identity) references acl_object_identity (id),
    constraint foreign_fk_5 foreign key (sid) references acl_sid (id)
) engine = innodb auto_increment = 758 default charset = latin1;

drop table if exists users;
create table if not exists users
(
    username varchar(50) not null,
    password varchar(50) not null,
    enabled  tinyint(1)  not null,
    primary key (username)
) engine = innodb default charset = latin1;

insert into users (username, password, enabled)
values ('admin', 'admin', 1),
       ('cust1', 'cust1', 1),
       ('cust2', 'cust2', 1);

drop table if exists authorities;
create table if not exists authorities
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    unique key authorities_idx_1 (username, authority),
    constraint authorities_ibfk_1 foreign key (username) references users (username)
) engine = innodb default charset = latin1;

insert into authorities (username, authority)
values ('admin', 'ROLE_ADMIN'),
       ('cust1', 'ROLE_CUSTOMER'),
       ('cust2', 'ROLE_CUSTOMER');

drop table if exists fixed_deposit_details;
create table if not exists fixed_deposit_details
(
    id     bigint(20)  not null auto_increment,
    user   varchar(50) not null,
    amount varchar(50) not null,
    tenure varchar(50) not null,
    email  varchar(50) not null,
    primary key (id)
) engine = InnoDB auto_increment = 14 default charset = latin1 comment ='Contains fixed deposit details';
