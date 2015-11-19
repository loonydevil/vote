create database food;
use food;

drop table if exists user;
drop table if exists restorant;
drop table if exists menu;
drop table if exists vote;

create table user (
    id int not null auto_increment primary key,
    name varchar(50),
    email varchar(50) unique,
    password varchar(100),
    is_admin boolean default false
);

insert into user values(666, 'admin', 'admin', 'admin', true);
insert into user values(667, 'noadmin', 'noadmin', 'noadmin', false);

create table restorant (
    id int not null auto_increment primary key,
    name varchar(50)
);

create table menu (
    id int not null auto_increment primary key,
    restorant_id int not null,
    dish varchar(50),
    price  decimal(10,2) not null,

    constraint fk_restorant_id
    foreign key (restorant_id) references restorant(id)
    on delete cascade
);

create table vote (
    id int not null auto_increment primary key,
    restorant_id int not null,
    user_id int not null,
    
    constraint fk_vote_restorant_id
    foreign key (restorant_id) references restorant(id),
	constraint fk_user_id
    foreign key (user_id) references user(id)
    on delete cascade
);


