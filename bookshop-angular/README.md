# Bookshop-angular

-------------

[Angular](https://angular.io) frontend application for [Bookshop](https://github.com/AdrianBCodes/bookshop) project.

## Features

- Displaying data: Displaying user-friendly interface. Making requests to the API to read and change data.
- Create and update data: Using interface to collect user input and making requests to the API to create and update data.
- Error handling: Handling errors that may occur when making requests to the API, such as network errors, server errors, or validation errors.

## Built with

- [Angular](https://angular.io)


## Project setup

### Using Docker

#### Clone the repository
```console
git clone https://github.com/AdrianBCodes/bookshop.git
```

#### Build Docker Image
```console
cd bookshop-angular
docker build -t bookshop-angular:1.0
```

#### Start Docker Container
```console
docker run -p 4200:4200 bookshop-angular:1.0
```
This command will start the Docker container and expose port 4200 to the host system. You can change port number, if you want to expose it on a different one.

#### Access the application
```console
http://localhost:4200
```

Make sure you have Docker installed on your system before running the above commands.

### Without Docker

For building and running the application you need:
- [Angular CLI](https://github.com/angular/angular-cli)
- [Nodejs](https://nodejs.org/en)

#### Clone the repository
```console
git clone https://github.com/AdrianBCodes/bookshop.git
```

#### Build project
```console
cd bookshop-angular
ng build
```

#### Run project locally
```console
ng serve
```

#### Access the application
```console
http://localhost:4200
```
