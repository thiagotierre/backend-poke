FROM maven:3.9.8-amazoncorretto-17 AS maven
WORKDIR /usr/src/app
COPY . .
RUN mvn package -DskipTests

FROM openjdk:17-oracle
WORKDIR /usr/src/app
COPY --from=maven /usr/src/app/target/api-pokemon.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","app.jar", "-Xms512M", "-Xmx1024M"]