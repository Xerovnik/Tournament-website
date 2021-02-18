-- ********************************************************************************
-- Create new incomplete tournament: change the tournament id of the tournament
-- insertion and all the user insertions to create a new incomplete tournament.
-- Then log in as admin and go to the tournament to start the tournament 
-- ********************************************************************************

insert into tournaments
(tournament_id, tournament_name, host_id, status, tournament_date, max_participants)
values (500, 'Fake Tournament A', 2, 'Upcoming', '2021-03-03', 16);

insert into user_tournament(user_id, tournament_id)
values (101, 500),
(102, 500),
(103, 500),
(104, 500),
(105, 500),
(106, 500),
(107, 500),
(108, 500),
(109, 500),
(110, 500),
(111, 500),
(112, 500),
(113, 500),
(114, 500),
(115, 500),
(116, 500);