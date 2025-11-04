FROM mcr.microsoft.com/openjdk/jdk:25-ubuntu
COPY /target/Portfolio-0.0.1-SNAPSHOT.jar /wkdir/portfolio.jar
WORKDIR /wkdir
ENTRYPOINT ["java", "-jar", "portfolio.jar"]
