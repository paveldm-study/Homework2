DROP TABLE IF EXISTS shop;

-- Create the "shop" database
CREATE DATABASE shop;

-- Connect to the "shop" database
\c shop;

CREATE TABLE "user" ( user_id INT PRIMARY KEY, username VARCHAR(50), orders VARCHAR(255) );

CREATE TABLE "order" ( order_id INT PRIMARY KEY, user_id INT, goods VARCHAR(255), quantity INT, FOREIGN KEY (user_id) REFERENCES "user"(user_id) );

CREATE TABLE good ( good_id INT PRIMARY KEY, name VARCHAR(50) );