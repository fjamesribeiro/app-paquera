FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/api-paqueradebar-1.0.0.jar api-paqueradebar-1.0.0.jar
EXPOSE 8080
CMD [ "java", "-jar", "api-paqueradebar-1.0.0.jar" ]