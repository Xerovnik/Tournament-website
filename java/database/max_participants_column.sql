alter table tournaments
add column max_participants int not null default 8;

update tournaments
set max_participants = 4
where tournament_id = 0;