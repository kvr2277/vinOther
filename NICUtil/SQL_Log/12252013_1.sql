CREATE TABLESPACE INVENTORY
  DATAFILE 'inventory.dat' 
    SIZE 20M
  ONLINE;
  
  CREATE TEMPORARY TABLESPACE INVENTORY_TEMP
  TEMPFILE 'inventory_temp.dbf'
    SIZE 5M
    AUTOEXTEND ON;

CREATE USER vinoracle
  IDENTIFIED BY password
  DEFAULT TABLESPACE INVENTORY
  TEMPORARY TABLESPACE INVENTORY_TEMP  
  QUOTA 20M on INVENTORY;
  
  
 GRANT create session TO vinoracle;
GRANT create table TO vinoracle;
GRANT create view TO vinoracle;
GRANT create any trigger TO vinoracle;
GRANT create any procedure TO vinoracle;
GRANT create sequence TO vinoracle;
GRANT create synonym TO vinoracle;

CREATE TABLE address
(
  vendor_id numeric(8) not null,
  address_id numeric(10) not null,
  address_line_1 varchar2(50) not null,
  address_line_2 varchar2(50),
  city varchar2(20),
  state varchar2(30),
  country varchar2(20) not null,
  zipcode varchar2(5) not null,
  CONSTRAINT address_pk PRIMARY KEY (address_id)
);


insert into address
values (001, 1234567890, '2141 QUEENS DR', 'APT#B3', 'HARRISBURG', 'PENNSYLVANIA', 'UNITED STATES', '17110')

select * from Address