FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/plataforma-educativa-cloud-0.0.1-SNAPSHOT.jar app.jar
COPY wallet /app/wallet

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=oracle"]