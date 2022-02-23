INSERT INTO `authorities` (`customer_id`, `name`)
 VALUES (1, 'READ');

INSERT INTO `authorities` (`customer_id`, `name`)
 VALUES (1, 'WRITE');

UPDATE authorities SET name="ROLE_USER" WHERE id=1;
UPDATE authorities SET name="ROLE_ADMIN" WHERE id=2;