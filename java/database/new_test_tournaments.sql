insert into tournaments
(tournament_id, tournament_name, host_id, status, tournament_date, max_participants)
values (100, 'Test Tournament 4 Participants', 2, 'Ongoing', '2021-01-01', 4),
(200, 'Test Tournament 8 Participants', 2, 'Ongoing', '2021-01-01', 8);

insert into matches
(tournament_id, user1, user2, round, winner)
values (100, 1, 2, 1, 1),
(100, 2, 3, 1, 3),
(100, 1, 3, 2, 1),
(200, 1, 2, 1, 1),
(200, 3, 4, 1, 3),
(200, 5, 6, 1, 5),
(200, 7, 8, 1, 7),
(200, 1, 3, 2, 1),
(200, 5, 7, 2, 7),
(200, 1, 7, 3, 7);