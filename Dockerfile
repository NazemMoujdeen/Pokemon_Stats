# 1. Build the App
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# 2. Run the App
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/pokemon-stats-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]