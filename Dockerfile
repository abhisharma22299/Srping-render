From maven:3.8.5-openjdk17 AS build
COPY . .
RUN mvn clean package -DskipTests
From openjdk:17.0.1-jdk-slim
COPY --from=build/traget/SmartContactManager-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]   
