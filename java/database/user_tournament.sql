-- **************************************************************
-- This script creates a user_tournament table and adds pairs
-- **************************************************************

BEGIN TRANSACTION;

DROP TABLE IF EXISTS user_tournament;

create table user_tournament(
user_id int not null,
tournament_id int not null,
seed int default 0 not null,
record varchar(7) default '0-0' not null,
constraint PK_user_tournament primary key(user_id, tournament_id),
constraint FK_user_tournament_user_id foreign key(user_id) references users(user_id),
constraint FK_user_tournament_tournament_id foreign key(tournament_id) references tournaments(tournament_id)
);

insert into user_tournament(user_id, tournament_id)
values (1, 1),
(1, 1),
(2, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 2),
(4, 2),
(5, 2),
(6, 2);

COMMIT TRANSACTION;