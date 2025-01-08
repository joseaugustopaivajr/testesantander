# Etapa 1: Usar uma imagem Gradle com JDK 17 para compilar a aplicação
FROM gradle:7.6.0-jdk17 AS build
WORKDIR /app

COPY build.gradle .
COPY settings.gradle .
COPY src ./src
RUN gradle build -x test --no-

# Etapa 3: Configurar banco de dados
ENV DATABASE_URL=jdbc:mysql://mysql:3306/zipcode_db
ENV DATABASE_USERNAME=root
ENV DATABASE_PASSWORD=root_password

# Etapa 2: Usar uma imagem com JDK 17 para rodar a aplicação
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/main-0.0.1.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
