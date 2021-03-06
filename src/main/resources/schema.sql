DROP TABLE IF EXISTS DEALER;
DROP TABLE IF EXISTS DEALER;

CREATE TABLE DEALER (
id_dealer INT AUTO_INCREMENT  PRIMARY KEY,
nome VARCHAR(200) NOT NULL,
tier_limit INT(3) NOT NULL
);

CREATE TABLE LISTING (
id_listing INT AUTO_INCREMENT  PRIMARY KEY,
dealer_id INT NOT NULL,
vehicle VARCHAR(100) NOT NULL,
price NUMERIC(20, 2) NOT NULL,
created_at DATE NOT NULL,
state varchar(10) NOT NULL,
CONSTRAINT fk_id_dealer FOREIGN KEY (dealer_id)
    REFERENCES DEALER (id_dealer)
  ON DELETE CASCADE ON UPDATE NO ACTION
);

