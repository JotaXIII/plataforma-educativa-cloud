FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/plataforma-educativa-cloud-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]