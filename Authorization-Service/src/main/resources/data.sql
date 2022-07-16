drop table if exists userrecord;
create table userrecord(user_id int primary key ,user_name varchar(50),user_password varchar(20), name varchar(30), mobile long);


INSERT INTO userrecord (user_id,user_name,user_password) VALUES (101,'ayush@gmail.com','1234');
INSERT INTO userrecord (user_id,user_name,user_password) VALUES (102,'vineet@gmail.com','6287');
INSERT INTO userrecord (user_id,user_name,user_password) VALUES (103,'nayan@gmail.com','8822');
INSERT INTO userrecord (user_id,user_name,user_password) VALUES (104,'poornima@gmail.com','7612');
