create table posts(
    id serial not null,
    content varchar(250),
    description varchar(250) not null,
    title varchar(100) not null,
    primary key (id)
);

create table comments (
    id serial not null,
    text varchar(250) not null,
    post_id int not null,
    primary key (id)
);

alter table comments add foreign key (post_id) references posts (id);