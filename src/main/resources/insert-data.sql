CREATE TABLE t_customer (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  total_price  INTEGER ,
  city VARCHAR(30),
  zip VARCHAR(30),
  area VARCHAR(30)
);

CREATE TABLE t_order (
  id         INTEGER PRIMARY KEY,
  item_name VARCHAR(30),
  count  INTEGER ,
  customer_id INTEGER,
  FOREIGN KEY (customer_id) REFERENCES public.t_customer(id)
);


INSERT INTO t_order('id', 'item_name', 'count', 'customer_id') VALUES (1, 'Goa Tour Package', 10, 1);