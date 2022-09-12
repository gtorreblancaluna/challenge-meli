# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.3/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.7.3/reference/htmlsingle/#using.devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.3/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.3/reference/htmlsingle/#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

## Run Project locally
##### STEP 1. Software requirements
To run project locally, please you need install in your Operating System.
NOTE: this project is built with Java Spring Boot

* JDK 8 or higher
* MySQL Server 8 or higher
* Apache Maven 3 or higher

##### STEP 2. Create database and tables

* [File script](script-database.sql)

##### STEP 3. Install and run project
Commands in your terminal Linux, MAC our Power Shell for windows

* mvn clean install
* mvn spring-boot:run

## Deploy in Google Cloud App Engine
##### STEP 1. Software requirements

* Install Google Cloud SDK for Java in your local machine
* Credentials for Google Cloud gtorreblancaluna@gmail.com

##### STEP 2. Deploy app
go to project path in local directory

* mvn -DskipTests appengine:deploy -Pprod