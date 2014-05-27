CREATE DATABASE payment;

GRANT ALL ON payment.* TO springappuser@'%' IDENTIFIED BY 'pspringappuser';
GRANT ALL ON payment.* TO springappuser@localhost IDENTIFIED BY 'pspringappuser';

USE payment;

CREATE TABLE card (
  id INTEGER PRIMARY KEY,
  type varchar(10),
  buyLimitDiary double(15,2),
  buyLimitMonthly double(15,2),
  cashLimitDiary double(15,2),
  cashLimitMonthly double(15,2)
);
CREATE INDEX card_type ON card(type);