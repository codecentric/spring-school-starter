FROM adoptopenjdk/openjdk11:jdk-11.0.6_10-alpine-slim

RUN mkdir -p /app && chown -R daemon /app

USER daemon

WORKDIR /app

COPY ./target/17_spring_rest_server_dockerfile_solution-*.jar /app/17_spring_rest_server_dockerfile_solution.jar

CMD ["java", "-jar", "/app/17_spring_rest_server_dockerfile_solution.jar"]

EXPOSE 8080