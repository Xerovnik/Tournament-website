insert into tournaments
(tournament_id, tournament_name, host_id, status, tournament_date, max_participants)
values (300, 'Test Tournament 16 Participants', 2, 'Ongoing', '2021-01-01', 16);

insert into users
(user_id,username,password_hash,role, display_name)
values (101, 'wolverine','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Wolverine'),
(102, 'cyclops','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Cyclops'),
(103, 'storm','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Storm'),
(104, 'magneto','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Magneto'),
 (105, 'professor','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Professor X'),
 (106, 'beast','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Beast'),
 (107, 'quick','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'QuickSilver'),
 (108, 'jean','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Jean Grey'),
 (109, 'mystique','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Mystique'),
 (110, 'kitty','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Kitty Pryde'),
 (111, 'ice','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'IceMan'),
 (112, 'colossus','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Colossus'),
 (113, 'darwin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Darwin'),
 (114, 'night','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'NightCrawler'),
 (115, 'sabretooth','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Sabretooth'),
 (116, 'gambit','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Gambit');
 
insert into user_tournament(user_id, tournament_id)
values (101, 300),
(102, 300),
(103, 300),
(104, 300),
(105, 300),
(106, 300),
(107, 300),
(108, 300),
(109, 300),
(110, 300),
(111, 300),
(112, 300),
(113, 300),
(114, 300),
(115, 300),
(116, 300);


insert into matches
(tournament_id, user1, user2, round, winner)
values (300, 101, 102, 1, 101),
(300, 103, 104, 1, 103),
(300, 105, 106, 1, 105),
(300, 107, 108, 1, 107),
(300, 109, 110, 1, 109),
(300, 111, 112, 1, 112),
(300, 113, 114, 1, 114),
(300, 115, 116, 1, 115);

insert into matches
(tournament_id, user1, user2, round, winner)
values (300, 101, 103, 2, 101),
(300, 105, 107, 2, 107),
(300, 109, 112, 2, 112),
(300, 114, 115, 2, 115);

insert into matches
(tournament_id, user1, user2, round, winner)
values (300, 101, 107, 3, 101),
(300, 112, 115, 3, 112);

insert into matches
(tournament_id, user1, user2, round, winner)
values (300, 101, 112, 4, 112);