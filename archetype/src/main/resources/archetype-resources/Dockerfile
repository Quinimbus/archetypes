FROM eclipse-temurin:21 AS java-build-stage
WORKDIR app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw dependency:go-offline
COPY src src
RUN ./mvnw package

FROM scratch AS admin-ui-output-stage
WORKDIR app
COPY --from=java-build-stage /app/target/magic/admin-ui /output/magic/admin-ui

FROM eclipse-temurin:21 AS backend-final-stage
WORKDIR app
ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager -XX:-OmitStackTraceInFastThrow"
COPY --from=java-build-stage /app/target/quarkus-app/lib/ /app/lib/
COPY --from=java-build-stage /app/target/quarkus-app/*.jar /app/
COPY --from=java-build-stage /app/target/quarkus-app/app/ /app/app/
COPY --from=java-build-stage /app/target/quarkus-app/quarkus/ /app/quarkus/
CMD ["java", "-jar", "/app/quarkus-run.jar"]
