drop table if exists wishlist;

create table wishlist (
    id serial not null,
    title varchar(25) not null,
    event_type varchar(25),
    description varchar (1000),
    wishlist_date timestamp default now(),
    privacy_type varchar(10) default 'PRIVATE',
    primary key(id)
);

