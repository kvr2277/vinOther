--From System/Treat360

CREATE OR REPLACE DIRECTORY GEONAMES AS 'F:/dump';
GRANT READ ON DIRECTORY GEONAMES TO PUBLIC;
GRANT WRITE ON DIRECTORY GEONAMES TO PUBLIC;

CREATE TABLE geo_all_countries1
( geonameid INTEGER,
  name VARCHAR2(400),
  asciiname VARCHAR2(400),
  alternatenames clob,
  latitude VARCHAR2(32),
  longitude VARCHAR2(32),
  feature_class VARCHAR2(1),
  feature_code VARCHAR2(20),
  country_code VARCHAR2(2),
  cc2 VARCHAR2(120),
  admin1_code VARCHAR2(40),
  admin2_code VARCHAR2(160),
  admin3_code VARCHAR2(40),
  admin4_code VARCHAR2(40),
  population INTEGER,
  elevation INTEGER,
  dem VARCHAR2(32),
  time_zone VARCHAR2(32),
  modification_date VARCHAR2(32))
ORGANIZATION EXTERNAL
  (  TYPE ORACLE_LOADER
     DEFAULT DIRECTORY GEONAMES
     ACCESS PARAMETERS
       (records delimited BY '\n' CHARACTERSET UTF8
           BADFILE GEONAMES:'allCountries.bad'
           DISCARDFILE GEONAMES:'allCountries.discard'
           LOGFILE GEONAMES:'allCountries.log'
           skip 0
           fields terminated BY X'09'
           missing field VALUES are NULL
           ( geonameid CHAR(4000),
             name CHAR(4000),
             asciiname CHAR(4000),
             alternatenames CHAR(10000),
             latitude CHAR(4000),
             longitude CHAR(4000),
             feature_class CHAR(4000),
             feature_code CHAR(4000),
             country_code CHAR(4000),
             cc2 CHAR(4000),
             admin1_code CHAR(4000),
             admin2_code CHAR(4000),
             admin3_code CHAR(4000),
             admin4_code CHAR(4000),
             population CHAR(4000),
             elevation CHAR(4000),
             dem CHAR(4000),
             time_zone CHAR(4000),
             modification_date CHAR(4000)
           )
       )
     LOCATION ('allCountries.txt')
  )
  REJECT LIMIT UNLIMITED;
  
  CREATE TABLE geo_india
( geonameid INTEGER,
  name VARCHAR2(400),
  asciiname VARCHAR2(400),
  alternatenames clob,
  latitude VARCHAR2(32),
  longitude VARCHAR2(32),
  feature_class VARCHAR2(1),
  feature_code VARCHAR2(20),
  country_code VARCHAR2(2),
  cc2 VARCHAR2(120),
  admin1_code VARCHAR2(40),
  admin2_code VARCHAR2(160),
  admin3_code VARCHAR2(40),
  admin4_code VARCHAR2(40),
  population INTEGER,
  elevation INTEGER,
  dem VARCHAR2(32),
  time_zone VARCHAR2(32),
  modification_date VARCHAR2(32))
ORGANIZATION EXTERNAL
  (  TYPE ORACLE_LOADER
     DEFAULT DIRECTORY GEONAMES
     ACCESS PARAMETERS
       (records delimited BY '\n' CHARACTERSET UTF8
           BADFILE GEONAMES:'allCountries.bad'
           DISCARDFILE GEONAMES:'allCountries.discard'
           LOGFILE GEONAMES:'allCountries.log'
           skip 0
           fields terminated BY X'09'
           missing field VALUES are NULL
           ( geonameid CHAR(4000),
             name CHAR(4000),
             asciiname CHAR(4000),
             alternatenames CHAR(10000),
             latitude CHAR(4000),
             longitude CHAR(4000),
             feature_class CHAR(4000),
             feature_code CHAR(4000),
             country_code CHAR(4000),
             cc2 CHAR(4000),
             admin1_code CHAR(4000),
             admin2_code CHAR(4000),
             admin3_code CHAR(4000),
             admin4_code CHAR(4000),
             population CHAR(4000),
             elevation CHAR(4000),
             dem CHAR(4000),
             time_zone CHAR(4000),
             modification_date CHAR(4000)
           )
       )
     LOCATION ('IN.txt')
  )
  REJECT LIMIT UNLIMITED;
  
  
  select * from geo_india where name = 'Kondapur'