INSERT INTO ADDRESS(ID, COUNTRY, CITY, STREET, HOME, APARTMENT)
VALUES(1, 'england', 'london', 'power', '177', '666');

INSERT INTO CATEGORY(ID, NAME)
VALUES(1, 'soft');
INSERT INTO CATEGORY(ID, NAME)
VALUES(2, 'phones');

INSERT INTO USER(ID, LOGIN, PASSWORD, FIRSTNAME, LASTNAME, PHOTO, CASH, RATING, ROLE, STATUS)
VALUES (1, 'rel', '123', 'rel', 'mayer', 4, 0, 0, 'ADMIN', 'ACTIVE');
INSERT INTO USER(ID, LOGIN, PASSWORD, FIRSTNAME, LASTNAME, PHOTO, CASH, RATING, ROLE, STATUS)
VALUES (2, 'lil', '123', 'lil', 'torn', 1, 0, 0, 'USER', 'ACTIVE');
INSERT INTO USER(ID, LOGIN, PASSWORD, FIRSTNAME, LASTNAME, PHOTO, CASH, RATING, ROLE, STATUS)
VALUES (3, 'mel', '123', 'melissa', 'tox', 3, 0, 0, 'USER', 'INACTIVE');

INSERT INTO PRODUCT(ID, USER_ID, CATEGORY_ID, NAME, DESCRIPTION, PHOTO, COST, DISCOUNT, COUNT, RATING, STATUS)
VALUES (1, 2, 1, 'osx1', 'win', 1, 100, 0, 1, 0, 'ACTIVE');
INSERT INTO PRODUCT(ID, USER_ID, CATEGORY_ID, NAME, DESCRIPTION, PHOTO, COST, DISCOUNT, COUNT, RATING, STATUS)
VALUES (2, 2, 1, 'osx5', 'win', 2, 100, 0, 1, 1, 'ACTIVE');
INSERT INTO PRODUCT(ID, USER_ID, CATEGORY_ID, NAME, DESCRIPTION, PHOTO, COST, DISCOUNT, COUNT, RATING, STATUS)
VALUES (3, 2, 1, 'osx3', 'win', 3, 100, 50, 1, 2, 'ACTIVE');

INSERT INTO ORDERS(ID, USER_ID, PRODUCT_ID, ADDRESS_ID, BUYING_DATE, DELIVERY_DATE, STATUS)
VALUES(1, 3, 1, 1, '2018-06-04', '2018-06-04', 'ACTIVE');
INSERT INTO ORDERS(ID, USER_ID, PRODUCT_ID, ADDRESS_ID, BUYING_DATE, DELIVERY_DATE, STATUS)
VALUES(17, 2, 2, 1, '2018-06-04', '2018-06-04', 'ACTIVE');
INSERT INTO ORDERS(ID, USER_ID, PRODUCT_ID, ADDRESS_ID, BUYING_DATE, DELIVERY_DATE, STATUS)
VALUES (20, 2, 2, 1, '2018-06-04', null, 'ACTIVE');
INSERT INTO ORDERS(ID, USER_ID, PRODUCT_ID, ADDRESS_ID, BUYING_DATE, DELIVERY_DATE, STATUS)
VALUES (21, 2, 3, 1, '2018-06-04', null, 'ACTIVE');