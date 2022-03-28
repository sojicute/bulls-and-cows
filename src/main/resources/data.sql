insert into role (id, name) values (1, 'ROLE_USER');

insert into user (id, username, password) values (1,'Michelle', '$2a$12$UKUbaVdSFJ9Wv8sUgt4.uOloAncbb4P.ZMbrmDPnGXxFPu1NfdfgK');
insert into user (id, username, password) values (2,'Angela', '$2a$12$UKUbaVdSFJ9Wv8sUgt4.uOloAncbb4P.ZMbrmDPnGXxFPu1NfdfgK');
insert into user (id, username, password) values (3,'Kimberly', '$2a$12$UKUbaVdSFJ9Wv8sUgt4.uOloAncbb4P.ZMbrmDPnGXxFPu1NfdfgK');
insert into user (id, username, password) values (4,'Melissa', '$2a$12$UKUbaVdSFJ9Wv8sUgt4.uOloAncbb4P.ZMbrmDPnGXxFPu1NfdfgK');
insert into user (id, username, password) values (5,'William', '$2a$12$UKUbaVdSFJ9Wv8sUgt4.uOloAncbb4P.ZMbrmDPnGXxFPu1NfdfgK');
insert into user (id, username, password) values (6,'Richard', '$2a$12$UKUbaVdSFJ9Wv8sUgt4.uOloAncbb4P.ZMbrmDPnGXxFPu1NfdfgK');
insert into user (id, username, password) values (7,'Thomas', '$2a$12$UKUbaVdSFJ9Wv8sUgt4.uOloAncbb4P.ZMbrmDPnGXxFPu1NfdfgK');
insert into user (id, username, password) values (8,'Timothy', '$2a$12$UKUbaVdSFJ9Wv8sUgt4.uOloAncbb4P.ZMbrmDPnGXxFPu1NfdfgK');

INSERT INTO user_roles (user_id, roles_id) VALUES (1,1), (2,1), (3,1), (4,1), (5,1), (6,1), (7,1), (8,1);

insert into stat (game_count, attempt_count, average_attempt_count, user_id) values (34,  112, 112*1.0/34, 1);
insert into stat (game_count, attempt_count, average_attempt_count, user_id) values (34,  111, 111*1.0/34, 2);
insert into stat (game_count, attempt_count, average_attempt_count, user_id) values (15,  37, 37*1.0/15, 3);
insert into stat (game_count, attempt_count, average_attempt_count, user_id) values (9,  32, 32*1.0/9, 4);
insert into stat (game_count, attempt_count, average_attempt_count, user_id) values (14,  57, 57*1.0/14, 5);
insert into stat (game_count, attempt_count, average_attempt_count, user_id) values (12,  61, 61*1.0/12, 6);
insert into stat (game_count, attempt_count, average_attempt_count, user_id) values (7,  38, 38*1.0/7, 7);