CREATE TABLE Orders (
	order_id INT(5) NOT NULL AUTO_INCREMENT,
	product_id INT(5) NOT NULL,
	customer_id INT(5) NOT NULL,
	order_quantity INT(2) NOT NULL,
	order_amount FLOAT(2) NOT NULL,
	order_date DATETIME NOT NULL,
	delivery_date DATETIME NOT NULL,
	PRIMARY KEY (order_id)
);

CREATE TABLE Products (
	product_id INT(5) NOT NULL AUTO_INCREMENT,
	product_name varchar(255) NOT NULL UNIQUE,
	product_description varchar(500),
	product_price FLOAT NOT NULL,
	product_quantity INT(2) NOT NULL,
	PRIMARY KEY (product_id)
);

CREATE TABLE Customers (
	customer_id INT(5) NOT NULL AUTO_INCREMENT,
	customer_name varchar(255) NOT NULL,
	customer_phone BIGINT NOT NULL,
	customer_address varchar(255) NOT NULL,
	PRIMARY KEY (customer_id)
);

ALTER TABLE Orders ADD CONSTRAINT Orders_fk0 FOREIGN KEY (product_id) REFERENCES Products(product_id);

ALTER TABLE Orders ADD CONSTRAINT Orders_fk1 FOREIGN KEY (customer_id) REFERENCES Customers(customer_id);

INSERT INTO Products (product_id,product_name,product_description,product_price,product_quantity)
VALUES (10101,'Nikon Camera','Excellent professional grade DSLR camera',34999.56,56);

INSERT INTO Products (product_name,product_description,product_price,product_quantity)
VALUES ('Canon Camera','Best value for money professional grade DSLR camera',29999.89,16);

INSERT INTO Products (product_name,product_description,product_price,product_quantity) 
VALUES ('Sony Camera','Excellent cinematic 4K camera',54999.99,35);


INSERT INTO Products (product_name,product_description,product_price,product_quantity) 
VALUES ('GoPro Camera','Best action capturing camera',59599.56,89);


INSERT INTO Products (product_name,product_description,product_price,product_quantity) 
VALUES ('DJI Camera','Best drone camera',58299.00,79);


INSERT INTO Customers (customer_id,customer_name,customer_phone ,customer_address)
VALUES (20200,'Jane Doe',3259205252,'234, Vasco de Gama, Goa');

INSERT INTO Customers (customer_name,customer_phone ,customer_address)
VALUES ('John Mayer',9379205252,'582, Marine Drive, Mumbai');

INSERT INTO Customers (customer_name,customer_phone ,customer_address)
VALUES ('Steven Spiel',8279705252,'253, Film City, Mumbai');

INSERT INTO Customers (customer_name,customer_phone ,customer_address)
VALUES ('Martin Garrix',7689205252,'702, Hiranandani, Mumbai');

INSERT INTO Customers (customer_name,customer_phone ,customer_address)
VALUES ('Raju Hirani',9579205752,'625, Andheri, Mumbai');


INSERT INTO Orders (order_id ,product_id,customer_id ,order_quantity,order_amount,order_date,delivery_date)
VALUES (50250,10101,20200, 1,34999.56,NOW(),DATE_ADD(NOW(),INTERVAL 3 DAY));


