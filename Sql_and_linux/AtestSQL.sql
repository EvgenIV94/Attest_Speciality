CREATE DATABASE Друзья_человека;
USE Друзья_человека;

CREATE TABLE Домашние_животные (
    id INT AUTO_INCREMENT PRIMARY KEY,
    имя VARCHAR(100),
    команда VARCHAR(100),
    дата_рождения DATE
);

CREATE TABLE Вьючные_животные (
    id INT AUTO_INCREMENT PRIMARY KEY,
    имя VARCHAR(100),
    команда VARCHAR(100),
    дата_рождения DATE
);

INSERT INTO Домашние_животные (имя, команда, дата_рождения) VALUES
('Рекс', 'Сидеть', '2021-06-15'),
('Мурка', 'Лежать', '2022-03-10'),
('Шарик', 'Дай лапу', '2021-12-01');

INSERT INTO Вьючные_животные (имя, команда, дата_рождения) VALUES
('Гарри', 'Беги', '2020-12-01'),
('Босоног', 'Стой', '2021-09-20'),
('Каракуль', 'Лежать', '2019-07-15');

SELECT * FROM Домашние_животные;
SELECT * FROM Вьючные_животные;

SET SQL_SAFE_UPDATES = 0;
DELETE FROM Вьючные_животные WHERE имя = 'Верблюд';
SET SQL_SAFE_UPDATES = 1;

CREATE TABLE Лошади_Ослы AS
SELECT * FROM Вьючные_животные WHERE имя IN ('Гарри', 'Босоног');

SELECT * FROM Лошади_Ослы;

CREATE TABLE Молодые_животные AS
SELECT *,
    TIMESTAMPDIFF(MONTH, дата_рождения, CURDATE()) AS возраст_в_месяцах
FROM Домашние_животные
WHERE DATE_ADD(дата_рождения, INTERVAL 1 YEAR) <= CURDATE()
AND DATE_ADD(дата_рождения, INTERVAL 3 YEAR) > CURDATE();

SELECT * FROM Молодые_животные;

CREATE TABLE Все_животные AS 
SELECT 'Домашние' AS категория, имя, команда, дата_рождения 
FROM Домашние_животные 
UNION ALL 
SELECT 'Вьючные', имя, команда, дата_рождения 
FROM Вьючные_животные;

SELECT * FROM Все_животные;
