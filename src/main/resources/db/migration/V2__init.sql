create table done_exercises(
user_id bigint not null,
exercise_id bigint not null,
score int,
type varchar(55),
primary key(user_id, exercise_id)
);