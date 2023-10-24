# Bookshop

-------------

## Features

- Displaying data: Allowing users to view and sort data tables for core application's elements.
- Shopping experience: Simulate online shopping - looking for desired products, saving them to cart and make payment.
- Search and filtering: Allowing users to search and filter data displayed on the page.
- Create, update and delete data: Allowing users to create new data and update existing data.
- Error handling: Handling errors that may occur when making requests to the API, such as network errors, server errors, or validation errors.

## Built with

- Angular
- Java
- Gradle
- Spring JPA
- Spring Web
- MongoDB

## Project setup

### Using Docker

#### Clone the repository
```console
git clone https://github.com/AdrianBCodes/bookshop.git
```

#### Use Docker Compose
```console
docker-compose up -d
```

You can check status of application's stack
```console
docker-compose ps
```

#### Access the application
```console
http://localhost:4200
```

Make sure you have Docker installed on your system before running the above commands.

### Without Docker

In order to access full application you need to setup:
- bookshop-angular
- bookshop-java