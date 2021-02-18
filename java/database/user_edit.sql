-- **************************************************************
-- This script adds the 'display name' column to the 'user' table and adds fake users
-- **************************************************************

BEGIN TRANSACTION;

ALTER TABLE users
ADD COLUMN display_name varchar(50);

INSERT INTO users (username,password_hash,role, display_name) VALUES ('joe','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Joe Rogan');
INSERT INTO users (username,password_hash,role, display_name) VALUES ('denzel','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Denzel Washington');
INSERT INTO users (username,password_hash,role, display_name) VALUES ('harry','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Harry Potter');
INSERT INTO users (username,password_hash,role, display_name) VALUES ('blake','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Blake W');
INSERT INTO users (username,password_hash,role, display_name) VALUES ('robert','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Robert K');
INSERT INTO users (username,password_hash,role, display_name) VALUES ('jerome','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Jerome Z');
INSERT INTO users (username,password_hash,role, display_name) VALUES ('john','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'John Wick');
INSERT INTO users (username,password_hash,role, display_name) VALUES ('bugs','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Bugs Bunny');

COMMIT TRANSACTION;