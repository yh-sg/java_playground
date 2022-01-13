CREATE TABLE orders ( 
  order_id integer NOT NULL,
  order_date date,
  quantity integer,
  notes varchar(200),
  CONSTRAINT orders_pk PRIMARY KEY (order_id)
);