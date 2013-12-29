
CREATE TABLE vendor
(
  vendor_id numeric(8) not null,
  vendor_name varchar2(50) not null,
  vendor_tan varchar2(10) not null,
  vendor_type varchar2(3),
  CONSTRAINT vendor_pk PRIMARY KEY (vendor_id)
);

alter table address
drop column vendor_id;

CREATE SEQUENCE address_seq
 START WITH     1000
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
 CREATE SEQUENCE vendor_seq
 START WITH     1000
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
alter table
   vendor
add
   vendor_addr  numeric(8) NOT NULL;