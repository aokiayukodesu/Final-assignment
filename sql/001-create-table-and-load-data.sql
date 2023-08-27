DROP TABLE IF EXISTS purchase_histories;

CREATE TABLE purchase_histories(
  id int unsigned AUTO_INCREMENT,
  purchase_date date NOT NULL,
  purchase VARCHAR(100) NOT NULL,
  price int NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO purchase_histories (purchase_date,purchase,price) VALUES ("20230801","日用品",2000);
INSERT INTO purchase_histories (purchase_date,purchase,price) VALUES ("20230802","食料品",3000);
INSERT INTO purchase_histories (purchase_date,purchase,price) VALUES ("20230803","書籍",1000);
INSERT INTO purchase_histories (purchase_date,purchase,price) VALUES ("20230804","衣類",3000);