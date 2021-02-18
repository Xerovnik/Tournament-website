BEGIN TRANSACTION;

DROP TABLE IF EXISTS invites;
DROP SEQUENCE IF EXISTS seq_invites_id;

CREATE SEQUENCE seq_invites_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

create table invites(
invite_id int DEFAULT nextval('seq_invites_id'::regclass) NOT NULL,
tournament_id int not null,
participant_id int not null,
sender varchar(16) not null,
status varchar(16) not null default 'Pending',
read boolean not null default false,
constraint PK_invites primary key(invite_id),
constraint FK_invite_participant_id foreign key(participant_id) references users(user_id),
constraint FK_invites_tournament_id foreign key(tournament_id) references tournaments(tournament_id)
);

INSERT INTO users 
(user_id, username, password_hash, role, display_name) VALUES (0, 'test','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Test User');

insert into invites
(tournament_id, participant_id, sender)
values (0, 0, 'Participant');

COMMIT TRANSACTION;