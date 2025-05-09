## Project Title
A scalable tracking number generator API.

## Description
A scalable tracking number generator API build using Java language and Springboot framework.

## Dependencies
* Required JAVA sdk to be installed on host machine 
* Required a postgresql database to be setup on host machine

## Installing
* Download/clone/find the source from this github repositories : https://github.com/baihaqi-dg/Tracking_Number_Generator

## Executing program
* Modified the application.properties file connection configuration files accordingly(make sure the database and sequence is created).
* You can use below script to create sequence on database,
```
CREATE SEQUENCE tracking_number_seq START 1 INCREMENT 1 MINVALUE 1 MAXVALUE 9999  
```
* Run the source code using compiler or create the .JAR file to be used.
* Test the program using this URL https://tracking-number-generator.onrender.com/next-tracking-number(Deployed) using any sofware to test APIs (ex.Postman)
* Or you can test using the local URL once you have setup on your machine http://localhost:8080/next-tracking-number
* Make sure to use GET method and fill in the parameter required (origin_country_id, destination_country_id,weight,created_at,customer_id,customer_name,customer_slug)

## Authors
* Baihaqi

## Version History
* 0.1
    * Initial Release

