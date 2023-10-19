FROM gradle:8.4.0-jdk-alpine AS gradle-build

WORKDIR /app
COPY build.gradle settings.gradle /app/
COPY src /app/src
RUN gradle clean build --no-daemon

FROM openjdk:17

WORKDIR /app
COPY --from=gradle-build /app/build/libs/bookshop-java.jar /app/bookshop-java.jar
EXPOSE 8080
CMD ["java", "-jar", "bookshop-java.jar"]