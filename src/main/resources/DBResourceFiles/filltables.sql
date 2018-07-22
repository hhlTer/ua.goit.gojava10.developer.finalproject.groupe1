create database factorymanagment
character set utf8
collate utf8_general_ci;

USE factorymanagment;

INSERT INTO role(role_name)
VALUES ('ADMIN'),('USER'),('MODERATOR');

INSERT INTO account(login, password, active)

VALUES
('admin', '$2a$10$ZiAj9KXxIKlqbZNHbmhH0uulmJr1XSHRWrkdNmr62HNUgWdgnkQoC', 1),
('moder', '$2a$10$ZiAj9KXxIKlqbZNHbmhH0uulmJr1XSHRWrkdNmr62HNUgWdgnkQoC', 1),
('user', '$2a$10$XtgJHC/dZ8MURMlA6JJP7.UycrlQ9zCQuiJTC7OObTGyLq6SfZjgC', 1),
('Dervive', '$2a$10$XtgJHC/dZ8MURMlA6JJP7.UycrlQ9zCQuiJTC7OObTGyLq6SfZjgC', 1),
('Nare1964', '$2a$10$XtgJHC/dZ8MURMlA6JJP7.UycrlQ9zCQuiJTC7OObTGyLq6SfZjgC', 1),
('Exprow', '$2a$10$XtgJHC/dZ8MURMlA6JJP7.UycrlQ9zCQuiJTC7OObTGyLq6SfZjgC', 1),
('Renec1956', '$2a$10$XtgJHC/dZ8MURMlA6JJP7.UycrlQ9zCQuiJTC7OObTGyLq6SfZjgC', 1),
('Youttleste', '$2a$10$XtgJHC/dZ8MURMlA6JJP7.UycrlQ9zCQuiJTC7OObTGyLq6SfZjgC', 1),
('Hattes', '$2a$10$XtgJHC/dZ8MURMlA6JJP7.UycrlQ9zCQuiJTC7OObTGyLq6SfZjgC', 1),
('Theany61', '$2a$10$XtgJHC/dZ8MURMlA6JJP7.UycrlQ9zCQuiJTC7OObTGyLq6SfZjgC', 1);


INSERT INTO passport_data(tax_id, passport_number)
VALUES
('63789274', 'АК482195'),
('14020225', 'АК650356'),
('12643147', 'НВ241414'),
('66638783', 'НВ494425'),
('48296587', 'НН322043'),
('45506515', 'НН681046'),
('85248797', 'ЕР395016'),
('10304336', 'РК421037'),
('75481330', 'ДМ190136'),
('80374582', 'ДМ434526');

INSERT INTO work_position (position_name)
VALUES
('Design'),
('Developer'),
('Product owner'),
('Product manager');


INSERT INTO employee(first_name, last_name, email, telephone, photo_uri, account_id, born_date, sex, salary_per_hour, passport_data_id, work_position_id)
    VALUES
  ('Patricia', 'Acevedo', 'PatriciaWAcevedo@jourrapide.com', '631-812-1546', 'Patricia_A.jpeg', '1', '1996-08-05', 0, '20', '1', 4),
('Gene', 'Peck', 'GeneGPeck@dayrep.com', '870-995-2328', 'Gene_P.jpeg', '2', '1977-01-28', 1, '32', '2', 3),
('Victor', 'Thome', 'VictorDThome@jourrapide.com', '310-485-0857', 'Victor_D.jpeg', '3', '1980-08-31', 1, '32', '3', 1),
('Lorie', 'Keith', 'LorieMKeith@jourrapide.com', '209-342-3903', 'Lorie_K.jpeg', '4', '1987-06-04', 0, '28', '4', 1),
('Marjorie', 'Middleton', 'MarjorieQMiddleton@dayrep.com', '440-975-0912', 'Lorie_K.jpeg', '5', '1987-06-04', 0, '28', '5', 2),
('John', 'Pearce', 'JohnAPearce@teleworm.us', '310-739-5476', 'John_P.jpeg', '6', '1978-05-11', 1, '40', '6', 2),
('James', 'Spann', 'JamesMSpann@armyspy.com', '432-563-3395', 'James_S.jpeg', '7', '1953-03-03', 1, '40', '7', 2),
('Jon', 'Montano', 'JonDMontano@rhyta.com', '610-255-0957', 'Jon_M.jpeg', '8', '1982-05-29', 1, '35', '8', 2),
('Rose', 'Pawlowski', 'RoseJPawlowski@armyspy.com', '626-771-6521', 'Rose_P.jpeg', '9', '1967-11-07', 0, '40', '9', 2),
('Dorris', 'Bernal', 'DorrisLBernal@jourrapide.com', '850-937-7747', 'Dorris_B.jpeg', '10', '1975-09-18', 0, '30', '10', 2);


INSERT INTO status(status_name)
VALUES ('sick'), ('working'), ('vacation');


INSERT INTO event(event_name, description)
VALUES
('working day', 'the duration of a working day'),
('technical studies', 'the studies that help to improve your skills'),
('team building', 'the event that helps the team to work together better');

INSERT INTO workhours (start_time, finish_time, hours)
VALUES
('12:00:00', '20:00:00', '8'),
('10:00:00', '20:00:00', '10'),
('08:00:00', '20:00:00', '12'),
('10:00:00', '12:00:00', '2'),
('14:00:00', '18:00:00', '4');

INSERT INTO timetable (date, event_id, status_id, work_hours_id)
VALUES
('2018-07-30', '1', '2', '2'),
('2018-07-30', '1', '2', '2'),
('2018-07-30', '1', '2', '2'),
('2018-07-30', '1', '2', '2'),
('2018-07-30', '2', '2', '5'),
('2018-07-30', '2', '2', '5'),
('2018-07-30', '2', '2', '5'),
('2018-07-30', '3', '1', '4'),
('2018-07-30', '3', '2', '4'),
('2018-07-30', '3', '2', '4'),

('2018-07-31', '3', '2', '4'),
('2018-07-31', '3', '2', '4'),
('2018-07-31', '3', '3', '4'),
('2018-07-31', '3', '2', '4'),
('2018-07-31', '3', '2', '4'),
('2018-07-31', '3', '2', '4'),
('2018-07-31', '3', '2', '4'),
('2018-07-31', '3', '1', '4'),
('2018-07-31', '3', '2', '4'),
('2018-07-31', '3', '2', '4'),

('2018-07-31', '1', '2', '1'),
('2018-07-31', '1', '2', '1'),
('2018-07-31', '1', '3', '1'),
('2018-07-31', '1', '2', '1'),
('2018-07-31', '1', '2', '1'),
('2018-07-31', '1', '2', '1'),
('2018-07-31', '1', '2', '1'),
('2018-07-31', '1', '1', '1'),
('2018-07-31', '1', '2', '1'),
('2018-07-31', '1', '2', '1'),

('2018-08-01', '2', '2', '5'),
('2018-08-01', '2', '2', '5'),
('2018-08-01', '2', '3', '5'),
('2018-08-01', '1', '2', '3'),
('2018-08-01', '1', '2', '3'),
('2018-08-01', '1', '2', '3'),
('2018-08-01', '1', '2', '3'),
('2018-08-01', '1', '1', '3'),
('2018-08-01', '1', '2', '3'),
('2018-08-01', '1', '2', '3'),

('2018-08-01', '2', '2', '1'),
('2018-08-01', '2', '2', '1'),
('2018-08-01', '2', '3', '1');

INSERT INTO timetable_employee (timetable_id, employee_id) VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (1, 4),
  (1, 5),
  (2, 6),
  (2, 7),
  (2, 8),
  (3, 9),
  (3, 10),
  (3, 1),
  (3, 2);
