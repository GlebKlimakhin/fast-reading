create table exercises(
id bigserial not null unique,
data text not null,
type varchar(50) not null,
primary key (id)
);

create table users(
id bigserial not null primary key,
username varchar(55) not null unique,
password varchar(255) not null,
firstname varchar(55) not null,
lastname varchar(55) not null,
status varchar(55) default 'ACTIVE',
email varchar(55) unique,
role varchar(55) default 'USER'
);

create table roles(
id serial not null primary key,
name varchar(55) not null
);

insert into exercises(data, type) VALUES
('this is test reading exercise', 'READING_SPEED');

create table homeworks(
    id bigserial not null,
    primary key (id)
);

create table groups(
    id bigserial not null,
    name varchar(255) not null,
    primary key (id)
);

create table users_groups(
    user_id bigint not null,
    group_id bigint not null,
    primary key (user_id, group_id),
    foreign key (user_id) references users(id),
    foreign key (group_id) references groups(id)
);

create table groups_homeworks(
    group_id bigint not null,
    homework_id bigint not null,
    primary key (group_id, homework_id),
    foreign key (group_id) references groups(id),
    foreign key (homework_id) references homeworks(id)
);

insert into users(username, password, firstname, lastname) values
('Max', '123213', 'max', 'dobrynin');

insert into users (username, password, firstname, lastname, status, role) VALUES
('User', '$2a$10$bzak9YAk/d2t53LO/4fPe..h.LWti7gEfwOmapXBBYnmbdnkNrfNG', 'user', 'user', 'ACTIVE', 'ADMIN');

insert into groups(name) values
('Bababa');

insert into users_groups(user_id, group_id) values
(1, 1);

