-- **************************************************************
-- This script creates a tournament table and adds 2 fake tournaments
-- **************************************************************

BEGIN TRANSACTION;

DROP TABLE IF EXISTS tournaments;
DROP SEQUENCE IF EXISTS seq_tournament_id;

CREATE SEQUENCE seq_tournament_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE tournaments (
	tournament_id int DEFAULT nextval('seq_tournament_id'::regclass) NOT NULL,
	tournament_name varchar(50) NOT NULL,
	host_id int not null,
	status varchar(7) not null,
	tournament_date date not null,
	tournament_time time not null,
	CONSTRAINT PK_tournaments PRIMARY KEY (tournament_id),
	CONSTRAINT FK_tournaments_host foreign key(host_id) references users(user_id)
);

insert into tournaments(tournament_name, host_id, status, tournament_date, tournament_time)
values ('1-on-1 Basketball Tournament', '10', 'Ongoing', '2021-2-10', '1:30:00'),
('Smash 64 Tournament', '10', 'Ongoing', '2021-2-10', '12:30:00');

COMMIT TRANSACTION;

select * from tournaments;