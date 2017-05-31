INSERT INTO teams (id, city, name, position) VALUES (1, 'Казань', 'Дизель', 1);
INSERT INTO teams (id, city, name, position) VALUES (2, 'Казань', 'Центр', 2);
INSERT INTO teams (id, city, name, position) VALUES (3, 'Казань', 'Романт', 3);
INSERT INTO teams (id, city, name, position) VALUES (4, 'Альметьевск', 'Тимерхан', 4);
INSERT INTO teams (id, city, name, position) VALUES (5, 'Сыктывкар', 'Оскал', 5);
INSERT INTO teams (id, city, name, position) VALUES (6, 'Казань', 'Алтын', 6);
INSERT INTO teams (id, city, name, position) VALUES (7, 'Киров', 'Гром', 7);
INSERT INTO teams (id, city, name, position) VALUES (8, 'Казань', 'Инком', 8);
INSERT INTO teams (id, city, name, position) VALUES (9, 'Казань', 'Салават', 9);
INSERT INTO teams (id, city, name, position) VALUES (10, 'Казань', 'Ампер', 10);

INSERT INTO statuses (id, name) VALUES (1, 'USER');
INSERT INTO statuses (id, name) VALUES (2, 'ADMIN');

INSERT INTO users (id, email, first_name, gender, last_name, login, password, salt) VALUES
  (1, 'admin@mail.ru', 'Администратор', 'M', 'Админ', 'admin',
   '$2a$10$ToXoQBfIwpxfyT43H8oHl.ko.EI9aljZnJVkjiTK4UNYthl5QNgAm', 'koiu#0.6141941643794036s$req!');
INSERT INTO users (id, email, first_name, gender, last_name, login, password, salt) VALUES
  (2, 'sagit@mail.ru', 'Сагит', 'M', 'Халиуллин', 's', '$2a$10$z9MiCjgwQtAY5VHMdXAK4Oce9oURvSGajBBg1XU2Zs/6yVsA4mRN.',
   'koiu#0.3368119423152892s$req!');

INSERT INTO users_status (id, statusid, usersid) VALUES (1, 2, 1);
INSERT INTO users_status (id, statusid, usersid) VALUES (2, 1, 2);

INSERT INTO matches(about_goals, date, first_team_score, played, second_team_score, stadium, first_team_id, second_team_id) VALUES
  ('Захаров 1:0', '2017-05-31 12:09:28.421000', 1, TRUE, 0, 'TNA', 1, 3);
INSERT INTO matches(about_goals, date, first_team_score, played, second_team_score, stadium, first_team_id, second_team_id) VALUES
  ('Захаров 1:0', '2017-03-12 19:00:00.421000', 2, TRUE, 4, 'TNA', 1, 2);
INSERT INTO matches(about_goals, date, first_team_score, played, second_team_score, stadium, first_team_id, second_team_id) VALUES
  ('Захаров 1:0', '2017-01-11 19:00:00.421000', 2, TRUE, 0, 'TNA', 4, 1);
INSERT INTO matches(about_goals, date, first_team_score, played, second_team_score, stadium, first_team_id, second_team_id) VALUES
  ('Захаров 1:0', '2017-03-21 12:09:28.421000', 1, TRUE, 3, 'TNA', 1, 6);
INSERT INTO matches(about_goals, date, first_team_score, played, second_team_score, stadium, first_team_id, second_team_id) VALUES
  ('Захаров 1:0', '2017-01-12 19:00:00.421000', 1, TRUE, 4, 'TNA', 1, 5);
INSERT INTO matches(about_goals, date, first_team_score, played, second_team_score, stadium, first_team_id, second_team_id) VALUES
  ('Захаров 1:0', '2017-02-11 19:00:00.421000', 2, TRUE, 9, 'TNA', 2, 1);
INSERT INTO matches(about_goals, date, first_team_score, played, second_team_score, stadium, first_team_id, second_team_id) VALUES
  ('Захаров 1:0, Артемов 2:0', '2017-04-11 19:00:00.421000', 2, TRUE, 5, 'TNA', 8, 1);
INSERT INTO matches(about_goals, date, first_team_score, played, second_team_score, stadium, first_team_id, second_team_id) VALUES
  ('', '2017-09-16 19:00:00.421000', 0, FALSE , 0, 'TNA', 1, 9);
INSERT INTO matches(about_goals, date, first_team_score, played, second_team_score, stadium, first_team_id, second_team_id) VALUES
  ('', '2017-09-12 19:00:00.421000', 0, FALSE , 0, 'TNA', 1, 3);
INSERT INTO matches(about_goals, date, first_team_score, played, second_team_score, stadium, first_team_id, second_team_id) VALUES
  ('', '2017-08-12 19:00:00.421000', 0, FALSE , 0, 'TNA', 1, 6);
INSERT INTO matches(about_goals, date, first_team_score, played, second_team_score, stadium, first_team_id, second_team_id) VALUES
  ('', '2017-07-12 19:00:00.421000', 0, FALSE , 0, 'TNA', 4, 1);

INSERT INTO photos(name, match_id) VALUES ('1.jpg', 1);
INSERT INTO photos(name, match_id) VALUES ('2.jpg', 1);
INSERT INTO photos(name, match_id) VALUES ('3.jpg', 1);
INSERT INTO photos(name, match_id) VALUES ('4.jpg', 1);
INSERT INTO photos(name, match_id) VALUES ('5.jpg', 1);
INSERT INTO photos(name, match_id) VALUES ('6.jpg', 1);
INSERT INTO photos(name, match_id) VALUES ('1.jpg', 2);
INSERT INTO photos(name, match_id) VALUES ('2.jpg', 2);
INSERT INTO photos(name, match_id) VALUES ('3.jpg', 2);
INSERT INTO photos(name, match_id) VALUES ('4.jpg', 2);
INSERT INTO photos(name, match_id) VALUES ('5.jpg', 2);
INSERT INTO photos(name, match_id) VALUES ('6.jpg', 2);
INSERT INTO photos(name, match_id) VALUES ('7.jpg', 2);
INSERT INTO photos(name, match_id) VALUES ('8.jpg', 2);
INSERT INTO photos(name, match_id) VALUES ('9.jpg', 2);
INSERT INTO photos(name, match_id) VALUES ('10.jpg', 2);
INSERT INTO photos(name, match_id) VALUES ('11.jpg', 2);
INSERT INTO photos(name, match_id) VALUES ('12.jpg', 2);
INSERT INTO photos(name, match_id) VALUES ('13.jpg', 2);
INSERT INTO photos(name, match_id) VALUES ('1.jpg', 3);
INSERT INTO photos(name, match_id) VALUES ('2.jpg', 3);
INSERT INTO photos(name, match_id) VALUES ('3.jpg', 3);
INSERT INTO photos(name, match_id) VALUES ('4.jpg', 3);
INSERT INTO photos(name, match_id) VALUES ('5.jpg', 3);
INSERT INTO photos(name, match_id) VALUES ('6.jpg', 3);
INSERT INTO photos(name, match_id) VALUES ('1.jpg', 4);
INSERT INTO photos(name, match_id) VALUES ('2.jpg', 4);
INSERT INTO photos(name, match_id) VALUES ('3.jpg', 4);
INSERT INTO photos(name, match_id) VALUES ('1.jpg', 5);
INSERT INTO photos(name, match_id) VALUES ('2.jpg', 5);
INSERT INTO photos(name, match_id) VALUES ('3.jpg', 5);
INSERT INTO photos(name, match_id) VALUES ('4.jpg', 5);
INSERT INTO photos(name, match_id) VALUES ('5.jpg', 5);
INSERT INTO photos(name, match_id) VALUES ('6.jpg', 5);
INSERT INTO photos(name, match_id) VALUES ('7.jpg', 5);
INSERT INTO photos(name, match_id) VALUES ('8.jpg', 5);
INSERT INTO photos(name, match_id) VALUES ('9.jpg', 5);
INSERT INTO photos(name, match_id) VALUES ('10.jpg', 5);
INSERT INTO photos(name, match_id) VALUES ('1.jpg', 6);
INSERT INTO photos(name, match_id) VALUES ('2.jpg', 6);
INSERT INTO photos(name, match_id) VALUES ('3.jpg', 6);
INSERT INTO photos(name, match_id) VALUES ('4.jpg', 6);
INSERT INTO photos(name, match_id) VALUES ('5.jpg', 6);
INSERT INTO photos(name, match_id) VALUES ('6.jpg', 6);
INSERT INTO photos(name, match_id) VALUES ('7.jpg', 6);
INSERT INTO photos(name, match_id) VALUES ('8.jpg', 6);
INSERT INTO photos(name, match_id) VALUES ('9.jpg', 6);
INSERT INTO photos(name, match_id) VALUES ('10.jpg', 6);
INSERT INTO photos(name, match_id) VALUES ('1.jpg', 7);
INSERT INTO photos(name, match_id) VALUES ('2.jpg', 7);
INSERT INTO photos(name, match_id) VALUES ('3.jpg', 7);
INSERT INTO photos(name, match_id) VALUES ('4.jpg', 7);
INSERT INTO photos(name, match_id) VALUES ('5.jpg', 7);
INSERT INTO photos(name, match_id) VALUES ('6.jpg', 7);
INSERT INTO photos(name, match_id) VALUES ('7.jpg', 7);
INSERT INTO photos(name, match_id) VALUES ('8.jpg', 7);
INSERT INTO photos(name, match_id) VALUES ('9.jpg', 7);
INSERT INTO photos(name, match_id) VALUES ('10.jpg', 7);
INSERT INTO photos(name, match_id) VALUES ('11.jpg', 7);
INSERT INTO photos(name, match_id) VALUES ('12.jpg', 7);
INSERT INTO photos(name, match_id) VALUES ('13.jpg', 7);
INSERT INTO photos(name, match_id) VALUES ('14.jpg', 7);

INSERT INTO players(assists, birthdate, firstname, games, goals, grip, lastname, number, position, team_id) VALUES
  (1, '21.09.1997', 'Захар', 2, 3, 'L', 'Идрисов', 12, 'W', 1);
INSERT INTO players(assists, birthdate, firstname, games, goals, grip, lastname, number, position, team_id) VALUES
  (2, '22.09.1997', 'Игорь', 1, 3, 'L', 'Альфредов', 1, 'W', 1);
INSERT INTO players(assists, birthdate, firstname, games, goals, grip, lastname, number, position, team_id) VALUES
  (0, '29.09.1993', 'Прохор', 2, 1, 'R', 'Миронов', 3, 'W', 1);
INSERT INTO players(assists, birthdate, firstname, games, goals, grip, lastname, number, position, team_id) VALUES
  (1, '16.09.1997', 'Иван', 1, 3, 'L', 'Салакаев', 14, 'W', 1);
INSERT INTO players(assists, birthdate, firstname, games, goals, grip, lastname, number, position, team_id) VALUES
  (0, '19.09.1997', 'Закир', 2, 3, 'R', 'Петров', 21, 'W', 1);
INSERT INTO players(assists, birthdate, firstname, games, goals, grip, lastname, number, position, team_id) VALUES
  (2, '29.09.1995', 'Зильшот', 4, 3, 'L', 'Стасов', 65, 'D', 1);
INSERT INTO players(assists, birthdate, firstname, games, goals, grip, lastname, number, position, team_id) VALUES
  (1, '29.02.1997', 'Аббос', 2, 3, 'R', 'Серазетдинов', 56, 'W', 1);
INSERT INTO players(assists, birthdate, firstname, games, goals, grip, lastname, number, position, team_id) VALUES
  (0, '29.01.1996', 'Ивгат', 3, 2, 'L', 'Сакаев', 36, 'D', 1);
INSERT INTO players(assists, birthdate, firstname, games, goals, grip, lastname, number, position, team_id) VALUES
  (3, '29.09.1997', 'Ивгат', 3, 0, 'L', 'Мерзализаде', 89, 'G', 1);
INSERT INTO players(assists, birthdate, firstname, games, goals, grip, lastname, number, position, team_id) VALUES
  (3, '29.09.1997', 'Симон', 1, 0, 'L', 'Салимов', 43, 'G', 1);
INSERT INTO players(assists, birthdate, firstname, games, goals, grip, lastname, number, position, team_id) VALUES
  (1, '29.03.1997', 'Игнат', 2, 1, 'L', 'Мерзализаде', 76, 'F', 1);
INSERT INTO players(assists, birthdate, firstname, games, goals, grip, lastname, number, position, team_id) VALUES
  (3, '29.09.1997', 'Идрак', 2, 1, 'L', 'Мерзализаде', 43, 'D', 1);
INSERT INTO players(assists, birthdate, firstname, games, goals, grip, lastname, number, position, team_id) VALUES
  (1, '29.09.1992', 'Сергей', 2, 0, 'L', 'Захаров', 90, 'F', 1);
INSERT INTO players(assists, birthdate, firstname, games, goals, grip, lastname, number, position, team_id) VALUES
  (1, '29.03.1992', 'Ракип', 3, 0, 'L', 'Салимов', 9, 'D', 1);
INSERT INTO players(assists, birthdate, firstname, games, goals, grip, lastname, number, position, team_id) VALUES
  (2, '29.06.1997', 'Всеволод', 5, 2, 'L', 'Иванов-Карпенко', 7, 'D', 1);