FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# Копируем и собираем проект
COPY . .
RUN mvn clean package -DskipTests

# Переходим в runtime слой
FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
