# Stage 1: Build da aplicação com Maven
FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Faz o build do projeto
RUN mvn clean package

# Stage 2: Roda a aplicação com uma imagem leve de Java 17
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Executa a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
