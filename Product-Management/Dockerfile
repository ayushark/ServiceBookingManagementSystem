FROM java:8-jdk-alpine
EXPOSE 9000
ADD ./target/product /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch Account-Microservice-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","Account-Microservice-0.0.1-SNAPSHOT.jar"]