INSERT INTO users (user_id, username, orders) VALUES (1, 'Alice', 'Order1, Order2, Order3'); INSERT INTO users (user_id, username, orders) VALUES (2, 'Bob', 'Order4, Order5, Order6'); INSERT INTO users (user_id, username, orders) VALUES (3, 'Charlie', 'Order7, Order8, Order9');

INSERT INTO orders (order_id, user_id, goods, quantity) VALUES (1, 1, 'Good1', 5); INSERT INTO orders (order_id, user_id, goods, quantity) VALUES (2, 2, 'Good2', 3); INSERT INTO orders (order_id, user_id, goods, quantity) VALUES (3, 3, 'Good3', 7);

INSERT INTO goods (good_id, name) VALUES (1, 'Apple'); INSERT INTO goods (good_id, name) VALUES (2, 'Banana'); INSERT INTO goods (good_id, name) VALUES (3, 'Orange');