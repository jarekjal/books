create table vehicles(
    id serial not null,
    name varchar(100) null,
    engine varchar(100) null,
    frame varchar(100) null,
    vehicle_type varchar(10) not null,
    primary key (id)
);