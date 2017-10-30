
DROP DATABASE IF EXISTS nobelsDB;
CREATE DATABASE nobelsDB;



USE nobelsDB;


CREATE TABLE Author(
	first VARCHAR(30),
	last VARCHAR(30),
	country VARCHAR(30),
	born int(4),
	PRIMARY KEY(last)
	);
	
INSERT INTO Author VALUES
('Haruki', 'Murakami', 'Japan', 1949),
('Kindzaburo', 'Oe', 'Japan', 1935),
('Yasunari', 'Kawabata', 'Japan', 1899),
('Yukio', 'Mishima', 'Japan', 1925),
('Ivo', 'Andric', 'Yugoslavia', 1892),
('Mesa', 'Selimovic', 'Yugoslavia', 1910),
('Danilo', 'Kis', 'Yugoslavia', 1935),
('Julio', 'Cortazar', 'Argentina', 1914),
('Mario', 'Vargas Llosa', 'Peru', 1936),
('Jorge', 'Borges', 'Argentina', 1899),
('Gabriel Garcia', 'Marquez', 'Colombia', 1927);

CREATE TABLE Book(
	title VARCHAR(50),
	author VARCHAR(30),
	year int(4),
	PRIMARY KEY(title),
	FOREIGN KEY (author) REFERENCES Author(last)
	);

INSERT INTO BOOK VALUES
('Captain Pantoja and the Special Service', 'Vargas Llosa', 1978),
('The City and the Dogs', 'Vargas Llosa', 1963),
('Confessions of a Mask', 'Mishima', 1949),
('Patriotism', 'Mishima', 1961),
('Acts of Worship', 'Mishima', 1965),
('The Bridge on the Drina', 'Andric', 1945),
('The Damned Yard', 'Andric', null),
('Death and the Dervish', 'Selimovic', 1966),
('Axolotl', 'Cortazar', null),
('The Library of Babel', 'Borges', 1941),
('Labyrinths', 'Borges', null);
	

CREATE TABLE NobelWinner(
	author VARCHAR(30),
	year int(4),
	PRIMARY KEY(author),
	FOREIGN KEY (author) REFERENCES Author(last)
	);
	
INSERT INTO NobelWinner VALUES
('Andric', 1961),
('Kawabata', 1968),
('Vargas Llosa', 2010),
('Marquez', 1982),
('Oe', 1994);

	


