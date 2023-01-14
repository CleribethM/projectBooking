CREATE TABLE IF NOT EXISTS category (
  id bigint NOT NULL AUTO_INCREMENT,
  description varchar(150) NOT NULL,
  title varchar(50) NOT NULL,
  url varchar(200) NOT NULL,
  PRIMARY KEY (id)
);


