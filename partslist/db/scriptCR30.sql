DROP database if exists test;
create database test;
USE test;
SET NAMES utf8;
CREATE TABLE part (
  id INT(11) NOT NULL AUTO_INCREMENT, PRIMARY KEY (id),
  Name_item varchar(100) ,
  Needs TINYINT(1) default NULL,
  Quantity INT(11))
  COLLATE='utf8_general_ci';


INSERT INTO part (Name_item , Needs , Quantity) VALUES('материнская плата',1, 3 );
INSERT INTO part (Name_item , Needs , Quantity) VALUES('звуковая карта',0, 2);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('процессор',1, 2 );
INSERT INTO part (Name_item , Needs , Quantity) VALUES('подсветка корпуса',0, 0);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('HDD диск',0, 1 );
INSERT INTO part (Name_item , Needs , Quantity) VALUES('корпус',1, 10);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('память',1, 10 );
INSERT INTO part (Name_item , Needs , Quantity) VALUES('SSD диск',1, 15);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('видеокарта',0, 7 );
INSERT INTO part (Name_item , Needs , Quantity) VALUES('мышь',1, 78);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('клавиатура',1, 47 );
INSERT INTO part (Name_item , Needs , Quantity) VALUES('блок питания 5В',0, 16);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('блок питания 220В',1, 4 );
INSERT INTO part (Name_item , Needs , Quantity) VALUES('наушники',0, 27);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('колонки',0, 18);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('монитор 17',0, 6);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('монитор 19',0, 0);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('монитор 24',0, 11);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('сетевая карта',1, 19);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('куллер для БП',0, 17);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('куллер для видеокарт',0, 5);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('термопаста',0, 160);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('спиртовые салфетки',0, 11);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('кабель питания',1, 9);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('крепления',0, 0 );
INSERT INTO part (Name_item , Needs , Quantity) VALUES('CD/DVD привод',0, 24);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('микрофон',0, 19);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('веб-камера',0, 8);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('коврик',0, 142);
INSERT INTO part (Name_item , Needs , Quantity) VALUES('клавиатура с подсветкой',0, 13);