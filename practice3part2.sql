DROP DATABASE IF EXISTS thronesDB;
CREATE DATABASE thronesDB;


USE thronesDB;


CREATE TABLE Episodes(
	season int(1),
	num int(1),
	title VARCHAR(30),
	director VARCHAR(30),
	viewers INTEGER,
	PRIMARY KEY(season, num)
);

INSERT INTO Episodes VALUES
(1, 1, 'Winter is Coming', 'Van Patten', 2200000),
(1, 2, 'The Kingsroad', 'Van Patten', 2200000),
(1, 3, 'Lord Snow', 'Kirk', 2400000),
(1, 4, 'Cripples, Bastards', 'Kirk', 2400000),
(1, 5, 'The Wolf & the Lion', 'Kirk', 2600000),
(2, 1, 'The North Remembers', 'Taylor', 3900000),
(2, 2, 'The Night Lands', 'Taylor', 3800000),
(2, 3, 'What is Dead May Never Die', 'Sakharov', 3800000),
(2, 4, 'Garden of Bones', 'Petrarca', 3700000),
(2, 5, 'The Ghost of Harrenhal', 'Petrarca', 3900000);


CREATE TABLE Characters(
	name VARCHAR(30),
	house VARCHAR(20),
	PRIMARY KEY(name)
);

INSERT INTO Characters VALUES
('Eddard', 'Stark'),
('Robb', 'Stark'),
('Jon Snow', 'Stark'),
('Ygritte', null),
('Tyrion', 'Lannister'),
('Cercei', 'Lannister'),
('Jaime', 'Lannister'),
('Daenerys', 'Targaryen');



CREATE TABLE Appearances(
	name VARCHAR(30),
	season int(1),
	num int(1),
	PRIMARY KEY(name, season, num),
	FOREIGN KEY Appearances(name) REFERENCES Characters(name),
	FOREIGN KEY Appearances(season) REFERENCES Episodes(season)
	);
	




INSERT INTO Appearances VALUES
('Eddard', 1, 1),
('Eddard', 1, 2),
('Eddard', 1, 3),
('Eddard', 1, 4),
('Eddard', 1, 5),
('Robb', 1, 1),
('Robb', 1, 3),
('Robb', 2, 1),
('Robb', 2, 3),
('Jon Snow', 1, 1),
('Jon Snow', 1, 2),
('Jon Snow', 2, 3),
('Jon Snow', 2, 4),
('Jon Snow', 2, 5),
('Ygritte', 2, 4),
('Ygritte', 2, 5),
('Tyrion', 1, 1),
('Tyrion', 1, 2),
('Cercei', 1, 1),
('Cercei', 2, 3),
('Jaime', 2, 3),
('Jaime', 2, 4),
('Daenerys', 1, 1);