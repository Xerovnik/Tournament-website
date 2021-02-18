alter table tournaments
add end_date date;

alter table tournaments
drop column tournament_time;

alter table tournaments
alter status type varchar(14);

update tournaments
set status = 'Upcoming'
where tournament_name = '1-on-1 Basketball Tournament';

update tournaments
set status = 'Upcoming'
where tournament_name = 'Smash 64 Tournament';

update tournaments
set end_date = '2011-02-20'
where tournament_name = 'Pokemon';

update tournaments
set end_date = '2018-03-05'
where tournament_name = 'Street Fighter';