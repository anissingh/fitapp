# Build
FROM maven:3.8.5-openjdk-17 as build
LABEL authors="anissingh"
WORKDIR /home/app
COPY src ./src
COPY pom.xml .
RUN mvn -f /home/app/pom.xml clean package


# Package
FROM openjdk:17-jdk-slim as package
LABEL authors="anissingh"
ENV APP_HOME=/usr/src/app
WORKDIR ${APP_HOME}
RUN groupadd spring && useradd spring -g spring
RUN chown -R spring:spring ${APP_HOME} && chmod g+s ${APP_HOME}
ARG JAR_VERSION=0.0.1-SNAPSHOT
COPY --from=build --chown=spring:spring /home/app/target/backend-${JAR_VERSION}.jar ./backend.jar
EXPOSE 8080
USER spring:spring
ENTRYPOINT ["java", "-jar", "./backend.jar"]
