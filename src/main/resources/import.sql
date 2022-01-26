INSERT INTO restaurants (address, cuisine, name, rating) VALUES ('Deribasivska', 'Asian', 'Chin-Chin', 9);
INSERT INTO restaurants (address, cuisine, name, rating) VALUES ('Brooklyn 123', 'Fast-Food', 'MCDonalds', 7);
INSERT INTO restaurants (address, cuisine, name, rating) VALUES ('Henuezskaya', 'Asian', 'Sababa', 8);
INSERT INTO restaurants (address, cuisine, name, rating) VALUES ('Lyderovskiy blvrd', 'Ukrainia', 'Kompot', 10);

INSERT INTO dish_category (description, name) VALUES ('This dish usually is used as main', 'First dish');
INSERT INTO dish_category (description, name) VALUES ('This dish usually is used as additional', 'Second dish');
INSERT INTO dish_category (description, name) VALUES ('This dish usually is used as the last one' , 'Desert');

INSERT INTO dishes (description, name, portion_size, price, cat_id) VALUES ('Just an amazing WOK', 'WOK with chicken', '400 g', 160, 1);
INSERT INTO dishes (description, name, portion_size, price, cat_id) VALUES ('Just an amazing Napoleon', 'Cake Napoleon', '500 g', 140, 3);

INSERT INTO couriers (email, first_name, last_name, phone, transport, rest_id) VALUES ('oleg123@gmail.com', 'Oleg', 'Tarasenko', '0998887766', 'cycle', 1);

INSERT INTO orders (date, destination, price, status, courier_id, rest_id, user_id) VALUES ('2021-11-05', 'Odessa, Kostandi 103', 300, 'DELIVERED', 1, 1, null);
INSERT INTO orders_dishes (ord_id, dish_id) VALUES (1, 1);
INSERT INTO orders_dishes (ord_id, dish_id) VALUES (1, 2);
