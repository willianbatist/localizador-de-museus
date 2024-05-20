FROM eclipse-temurin:17-jdk-jammy as build-image

WORKDIR /to-build-app

COPY . .

RUN ./mvnw clean package

FROM eclipse-temurin:17

WORKDIR /app

COPY --from=build-image /app/target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
