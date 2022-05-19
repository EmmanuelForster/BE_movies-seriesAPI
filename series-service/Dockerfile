FROM openjdk:17-alpine
ARG JAR_FILE=./target/series-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
RUN apk update
RUN apk --no-cache add curl
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8098