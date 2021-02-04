create table authors (
    id serial not null,
    name varchar(50) not null,
    surname varchar(100) not null,
    primary key (id)
);

alter table books add column author_id int null;
alter table books add foreign key (author_id) references authors (id);