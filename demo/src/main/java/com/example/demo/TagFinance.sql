drop database TagFinance
CREATE DATABASE TagFinance;

USE TagFinance;

CREATE TABLE TagFinance (
  id INT NOT NULL PRIMARY KEY,
  name VARCHAR(255),
  description VARCHAR(255)
);

CREATE TABLE Transactions (
  createdAt varchar(30),
  title VARCHAR(255),
  description VARCHAR(255),
  amount DECIMAL(10,2),
  tagId INT,
  FOREIGN KEY (tagId) REFERENCES TagFinance(id)
);
select * from Transactions
select * from TagFinance