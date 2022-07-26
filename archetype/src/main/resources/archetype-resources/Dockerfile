FROM maven:3.8.1-openjdk-17 as build-stage
WORKDIR quarkus
ADD pom.xml .
RUN mvn dependency:go-offline
ADD src src
RUN mvn package

FROM openjdk:17 as production-stage
WORKDIR quarkus
ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager -XX:-OmitStackTraceInFastThrow"
COPY --from=build-stage /quarkus/target/quarkus-app/lib/ /quarkus/lib/
COPY --from=build-stage /quarkus/target/quarkus-app/*.jar /quarkus/
COPY --from=build-stage /quarkus/target/quarkus-app/app/ /quarkus/app/
COPY --from=build-stage /quarkus/target/quarkus-app/quarkus/ /quarkus/quarkus/

CMD ["java", "-jar", "/quarkus/quarkus-run.jar"]