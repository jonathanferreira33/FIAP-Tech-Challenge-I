DO $$
BEGIN
    CREATE TABLE TCDB_PAYMENT (
        idPayment SERIAL PRIMARY KEY,
        startDate TIMESTAMP NOT NULL,
        endDate TIMESTAMP,
        amount MONEY,
        status VARCHAR(50)
    );

    CREATE TABLE TCDB_USER (
        id SERIAL PRIMARY KEY UNIQUE,
        firstName VARCHAR(30) NOT NULL,
        lastName VARCHAR(30) NOT NULL,
        email VARCHAR(30) NOT NULL,
        is_admin BOOLEAN,
        userType VARCHAR(100),
        doc VARCHAR(14) NOT NULL,
        username VARCHAR(100),
        encrypted_password VARCHAR(128),
        enabled BOOLEAN,
        access_role VARCHAR(20),
        orders_id INTEGER
    );

    CREATE TABLE TCDB_ORDER (
        idOrder SERIAL PRIMARY KEY,
        startDate TIMESTAMP NOT NULL,
        endDate TIMESTAMP,
        user_id INTEGER,
        payment_id INTEGER,
        totalValue MONEY,
        FOREIGN KEY (user_id) REFERENCES TCDB_USER(id),
        FOREIGN KEY (payment_id) REFERENCES TCDB_PAYMENT(idPayment) ON DELETE CASCADE
    );

	ALTER TABLE TCDB_PAYMENT
	ADD COLUMN order_id INTEGER;

    ALTER TABLE TCDB_PAYMENT
	ADD CONSTRAINT fk_order_id FOREIGN KEY (order_id) REFERENCES TCDB_ORDER(idOrder) ON DELETE CASCADE;

    CREATE TABLE TCDB_PRODUCT (
        idProduct SERIAL PRIMARY KEY,
        productName VARCHAR(50) NOT NULL,
        price MONEY,
        shortDescription VARCHAR(120) NOT NULL,
        categoryCode INTEGER NOT NULL,
        orders INTEGER,
        FOREIGN KEY (orders) REFERENCES TCDB_ORDER(idOrder) ON DELETE CASCADE
    );

    CREATE TABLE TCDB_ORDER_PRODUCT (
        order_id INTEGER,
        product_id INTEGER,
        PRIMARY KEY (order_id, product_id),
        FOREIGN KEY (order_id) REFERENCES TCDB_ORDER(idOrder) ON DELETE CASCADE,
        FOREIGN KEY (product_id) REFERENCES TCDB_PRODUCT(idProduct) ON DELETE CASCADE
    );

EXCEPTION
    WHEN OTHERS THEN
        RAISE NOTICE 'Erro detectado: %', SQLERRM;
END;
$$;