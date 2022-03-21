INSERT INTO DEALER (id_dealer,nome,tier_limit) VALUES
  (1, 'Anderson', 5),
  (2, 'Brito', 1),
  (3, 'Oliveira', 4);

INSERT INTO LISTING (id_listing,dealer_id,vehicle,price,created_at,state) VALUES
(1, 1,'Tesla Model S', 10500.00,CURRENT_DATE(),'DRAFT'),
(2, 1,'Tesla Model X', 12500.00,CURRENT_DATE(),'DRAFT'),
(3, 1,'Tesla Model 3', 16000.00,CURRENT_DATE(),'DRAFT'),
(4, 2,'Mercedes GLA', 10000.00,CURRENT_DATE(),'DRAFT'),
(5, 3,'BMW X6', 12500.00,CURRENT_DATE(),'DRAFT'),
(6, 3,'BMW X7', 16000.00,CURRENT_DATE(),'DRAFT'),
(7, 3,'BMW 1 Series', 10500.00,CURRENT_DATE(),'DRAFT'),
(8, 3,'BMW 3 Series', 12500.00,CURRENT_DATE(),'DRAFT');