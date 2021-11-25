# ACTIVEDGE STOCK API

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![Coverage Status](https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master)](https://coveralls.io/github/codecentric/springboot-sample-app?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

[comment]: <> (Minimal [Spring Boot]&#40;http://projects.spring.io/spring-boot/&#41; sample app.)

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.active.edge.stock.api.activedge.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

Access
--------

#### GET ALL STOCKS

```
GET::http://localhost:8080/api/stocks
```

JSON Response:

```json
[ {
  "id" : 1,
  "name" : "Mobile Stock",
  "current_price" : 20000.0,
  "create_date" : 1637849105191,
  "last_update" : 1637849105191
}, {
  "id" : 2,
  "name" : "Bitcoin Stock",
  "current_price" : 50000.0,
  "create_date" : 1637849105191,
  "last_update" : 1637849105191
}, {
  "id" : 3,
  "name" : "Grain Stock",
  "current_price" : 40000.0,
  "create_date" : 1637849105191,
  "last_update" : 1637849105191
} ]
```


#### GET STOCK BY ID

```
GET::http://localhost:8080/api/stocks/1
```

JSON Response:

```json
{
  "id" : 1,
  "name" : "Mobile Stock",
  "current_price" : 20000.0,
  "create_date" : "2021-11-25T14:05:05.191+00:00",
  "last_update" : "2021-11-25T14:05:05.191+00:00"
}
```


#### UPDATE STOCK BY ID

```
PUT::http://localhost:8080/api/stocks
```

JSON Response:

```json
{
  "id" : 1,
  "name" : "NEW GRAIN",
  "current_price" : 30000.0,
  "create_date" : "2021-11-25T14:05:05.191+00:00",
  "last_update" : "2021-11-25T14:05:05.191+00:00"
}
```


#### CREATE STOCK

```
POST::http://localhost:8080/api/stocks
```

JSON Response:

```json
{
  "id" : 1,
  "name" : "Mobile Stock",
  "current_price" : 20000.0,
  "create_date" : "2021-11-25T14:05:05.191+00:00",
  "last_update" : "2021-11-25T14:05:05.191+00:00"
}
```


#### DELETE STOCK BY ID

```
DELETE::http://localhost:8080/api/stocks/1
```

JSON Response:

```json
{
  "status" : "OK",
  "success" : true,
  "errorCode" : 0,
  "data" : null,
  "message" : "Delete Successfully with Stock ID: 1",
  "timestamp" : "2021-11-25 02:05:05"
}
```

Edit
--------

Use Intellij

[comment]: <> (Generate all Eclipse files with Gradle.)

[comment]: <> (```sh)

[comment]: <> (./gradlew eclipse)

[comment]: <> (```)

License
-------

Apache License, Version 2.0

[doma]: https://github.com/domaframework/doma
[spring-boot]: https://github.com/spring-projects/spring-boot
