drop table chi_manager;

create table chi_manager(
  id INT PRIMARY KEY ,
  name VARCHAR(10),
  password VARCHAR(10)
);

insert into chi_manager VALUES (1,'luo','123456');

SELECT * from chi_manager;