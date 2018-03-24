CREATE DATABASE autowash;
use autowash;

CREATE TABLE customer(
sid INT NOT NULL AUTO_INCREMENT,
email VARCHAR(50),
name VARCHAR(50),
phone VARCHAR(50),
cname VARCHAR(50),
status VARCHAR(50),
PRIMARY KEY(sid) 
);

CREATE TABLE user (
  UserID INT NOT NULL AUTO_INCREMENT,
  Email VARCHAR(50),
  Password varchar(50),
  Type varchar(1),
  Name VARCHAR(50),
  PRIMARY KEY(UserID) 
);

  CREATE TABLE org (
  orgid INT NOT NULL AUTO_INCREMENT,
  cname VARCHAR(50),
  car_type varchar(50),
  time_required int,
  amount  VARCHAR(10),
  PRIMARY KEY(orgid) );

INSERT INTO org
  (cname, car_type, time_required,amount)
  VALUES 
  ('HUNTERSVILLE - AWASH', 'SUV','20','25'),
  ('HUNTERSVILLE - AWASH', 'SEDAN','15','15'),
  ('HARRIS TEETER - AWASH', 'SUV','10','35'), 
  ('HARRIS TEETER - AWASH', 'SEDAN','25','13'),
  ('HARRIS TEETER - AWASH', 'HATCHBACK','40','10'),
  ('DOWNTOWN - AWASH','RV','90', '80'),
  ('UPTOWN - AWASH', 'SUV','15','15');
  
select * from customer;	
select * from user;		
select * from org;

drop table customer;

UPDATE user
SET Type = 'A'
WHERE UserID = 1;