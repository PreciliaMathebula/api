FROM maven:3.8.5-openjdk-17-slim as build

COPY . .
RUN mvn clean package
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/api-0.0.1-SNAPSHOT.jar api.jar
EXPOSE 8080
CMD ["java", "-jar", "api.jar"]

#WORKDIR /app

#COPY target/api-0.0.1-SNAPSHOT.jar /app/api-0.0.1-SNAPSHOT.jar
#
#EXPOSE 8080
#
#CMD ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]
#
#


