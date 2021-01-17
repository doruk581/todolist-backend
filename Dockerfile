FROM openjdk:8-jdk-alpine
MAINTAINER dorukscs@gmail.com
VOLUME /tmp
ADD target/todolist-backend-1.0-SNAPSHOT.jar todolist-backend.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/todolist-backend.jar"]