update users
set display_name = 'Test User'
where username = 'user';

update users
set display_name = 'Admin'
where username = 'admin';

insert into tournaments 
(tournament_name, host_id, status, tournament_date, tournament_time) 
values ('Chess Tournament', 2, 'Ongoing','2021-02-1', '04:30:00'),
('Dungeons and Dragons', 2, 'Ongoing','2021-02-3', '10:30:00'),
('Ultimate Frisbee', 2, 'Ongoing','2021-01-10', '11:30:00'),
('Pokemon', 2, 'Closed','2011-02-10', '03:30:00'),
('Street Fighter', 2, 'Closed','2018-02-10', '07:30:00');