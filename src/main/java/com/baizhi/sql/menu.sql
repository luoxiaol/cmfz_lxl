CREATE TABLE chi_menu(
  id       int PRIMARY KEY ,
  tittle   VARCHAR(20),
  iconCls  VARCHAR(60),
  parentId INT,
  url      VARCHAR(60)
);

SELECT * FROM chi_menu;