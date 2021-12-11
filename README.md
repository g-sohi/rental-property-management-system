## rental-property-management-system
 Authors: Curtis Silva, Gurpartap Sohi, Ivan Suyat, Manpreet Singh (Group 18)

## Setting Up the MySQL Database
1. Log in to the MySQL server through the command prompt using the credentials for the "root" user.
2. Enter the following commands:
```
mysql> CREATE DATABASE rpms;
mysql> USE rpms;
mysql> SOURCE <PathOfSQLFile>;
```
 
## Installation
1. Clone the repository from github using the following command:
```
git clone https://github.com/g-sohi/rental-property-management-system.git
```

## Usage
1. Navigate to the root directory of the local repository.
2. Compile using: 
```
javac -cp ".;./lib/mysql-connector-java-8.0.23.jar" MainClass.java
```
3. Run using:
```
java -cp ".;./lib/mysql-connector-java-8.0.23.jar" MainClass
```
