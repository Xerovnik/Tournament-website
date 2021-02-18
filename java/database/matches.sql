BEGIN TRANSACTION;

DROP TABLE IF EXISTS matches;
DROP SEQUENCE IF EXISTS seq_matches_id;

CREATE SEQUENCE seq_matches_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

create table matches(
match_id int DEFAULT nextval('seq_matches_id'::regclass) NOT NULL,
tournament_id int not null,
user1 int not null,
user2 int not null,
round int not null,
winner int,
constraint PK_matches primary key(match_id),
constraint FK_matches_user_id_1 foreign key(user1) references users(user_id),
constraint FK_matches_user_id_2 foreign key(user2) references users(user_id),
constraint FK_matches_tournament_id foreign key(tournament_id) references tournaments(tournament_id)
);

insert into tournaments
(tournament_id, tournament_name, host_id, status, tournament_date, end_date)
values (0, 'Test Tournament', 1, 'Closed', '2015-10-20','2015-10-28');

insert into user_tournament(user_id, tournament_id)
values (3, 0),
(4, 0),
(5, 0),
(6, 0);

insert into matches
(tournament_id, user1, user2, round, winner)
values (0, 3, 4, 1, 3),
(0, 5, 6, 1, 6),
(0, 3, 6, 2, 6);

COMMIT TRANSACTION;

