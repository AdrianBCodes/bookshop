# Bookshop-java

-------------

Java and Spring boot REST API for [Bookshop](https://github.com/AdrianBCodes/bookshop) project.

## Features
- Create, read or update database records for core application's elements (Products, Carts).
- Unit testing with [JUnit](https://junit.org/junit5/).

## Built with

- Java
- Gradle
- Spring JPA
- Spring Web
- MongoDB

## Project setup

#### Clone the repository
```console
git clone https://github.com/AdrianBCodes/bookshop.git
```
### Using Docker

#### Build Docker Image
```console
cd bookshop-java
docker build -t bookshop-java:1.0 .
```

#### Start Docker Container
```console
docker run -p 8080:8080 bookshop-java:1.0
```
This command will start the Docker container and expose port 8080 to the host system. You can change port number, if you want to expose it on a different one.

#### Access the application
```console
http://localhost:8080
```

Make sure you have Docker installed on your system before running the above commands.

### Without Docker

For building and running the application you need:

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3](https://maven.apache.org)
- [MongoDB](https://www.mongodb.com)

Be aware that you need to locally setup MongoDB database named "bookshop" on port 27017 or configure `bookshop/src/main/resources/application.properties` for your own database.

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `org.bookshop.Main` class from your IDE.

Alternatively you can use Gradle like so:

```shell
gradle bootRun
```

Make sure you have Gradle installed on your system before running the above command. [Guide to install Gradle.](https://gradle.org/install)