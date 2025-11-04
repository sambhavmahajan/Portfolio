FROM mcr.microsoft.com/openjdk/jdk:25-ubuntu
WORKDIR /wkdir
COPY /target/Portfolio-0.0.1-SNAPSHOT.jar portfolio.jar
ENTRYPOINT ["java", "-jar", "portfolio.jar"]
