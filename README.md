# Project

## Installation procedure

1. Setup MySql connection, with docker by running this command:
   docker run -d --name mysqldb -p 3307:3306 -e MYSQL_ROOT_PASSWORD=123456 -h127.0.0.1 mysql:latest

2. Open MySQL Workbench

3. Connect to the MySQL connection

4. Open script file create-database.sql and execute the file to create the database

5. Open the application in the IDE of preference