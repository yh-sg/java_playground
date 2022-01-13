ALTER TABLE orders
ADD COLUMN item_num VARCHAR(20);

CREATE TABLE prices
( id serial PRIMARY KEY,
  product_name VARCHAR (50),
  product_description VARCHAR (50),
  price numeric CHECK(price > 0)
);