FROM java:8-jdk-alpine

COPY target/todo-app-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch todo-app-0.0.1-SNAPSHOT.jar'

ARG JAR_FILE=target/todo-app-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","todo-app-0.0.1-SNAPSHOT.jar"]