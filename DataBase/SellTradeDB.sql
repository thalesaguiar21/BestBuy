-- Tables

CREATE TABLE Product (
  idProduct serial NOT NULL,
  Seller_idSeller INTEGER NOT NULL,
  name varchar(60),
  cost varchar(15),
  tipo varchar(30),
  descr varchar(150),
  pusage varchar(30),
  anounceLink varchar(300),
  CONSTRAINT Product_Pk PRIMARY KEY(idProduct)
);

CREATE TABLE Seller (
  idSeller serial NOT NULL,
  name varchar(80) ,
  addr varchar(100) ,
  cpf varchar(14) ,
  contact varchar(20) ,
  CONSTRAINT Seller_Pk PRIMARY KEY(idSeller)
);

-- Functions and Triggers

CREATE FUNCTION Insert_prod() RETURNS trigger AS $Prod_trigger$
BEGIN
	-- Verifica se o vendedor está cadastrado no banco
	IF NOT EXISTS(SELECT idSeller FROM Seller WHERE NEW.seller_idSeller = idSeller) THEN
	RAISE EXCEPTION 'Vendedor não cadastrado!';
    END IF;
    RETURN NEW;
END;
$Prod_trigger$ LANGUAGE plpgsql;

CREATE TRIGGER Insert_prod BEFORE INSERT OR UPDATE
ON Product
FOR EACH ROW EXECUTE
PROCEDURE Insert_prod();


-- Insertions
INSERT INTO Seller (name, addr, cpf, contact) 
VALUES ('ExampleSeller', 'ExampleAddr', '000.000.000-00', '000000000000');

INSERT INTO Seller (name, addr, cpf, contact) 
VALUES ('ExampleSeller2', 'ExampleAddr2', '000.000.000-02', '000000000002');

INSERT INTO Seller (name, addr, cpf, contact) 
VALUES ('ExampleSeller3', 'ExampleAddr3', '000.000.000-03', '000000000003');

INSERT INTO Product (seller_idSeller, name, cost, tipo, descr, pusage, anounceLink) 
VALUES (1, 'ExampleProd', '30,3', 'TIPO A', 'ExampleDescr', 'ExampleUsage', 'www.anounce.com');

INSERT INTO Product (seller_idSeller, name, cost, tipo, descr, pusage, anounceLink) 
VALUES (2, 'ExampleProd2', '30,3', 'TIPO B', 'ExampleDescr2', 'ExampleUsage2', 'www.anounce2.com');

INSERT INTO Product (seller_idSeller, name, cost, tipo, descr, pusage, anounceLink) 
VALUES (1, 'ExampleProd', '30,3', 'TIPO C', 'ExampleDescr3', 'ExampleUsage3', 'www.anounce3.com');


