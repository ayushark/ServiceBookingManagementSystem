FROM openjdk:17-alpine
COPY ./target/Authorization-Service-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch Authorization-Service-0.0.1-SNAPSHOT'
ENTRYPOINT ["java","-jar","Authorization-Service-0.0.1-SNAPSHOT"]