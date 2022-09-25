FROM eclipse-temurin:17 as builder
WORKDIR application
ARG JAR_FILE=build/libs/market-service.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM eclipse-temurin:17
ENV PORT=8180
WORKDIR application
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
ENTRYPOINT ["java", "-Dserver.port=${PORT:-8180}", "-Xms128m", "-Xmx512m", "org.springframework.boot.loader.JarLauncher"]