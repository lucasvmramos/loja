FROM openjdk:17-jdk-slim
EXPOSE 8080
ADD /target/loja-0.0.1-SNAPSHOT.jar loja.jar
ENTRYPOINT ["java","-jar","/loja.jar"]