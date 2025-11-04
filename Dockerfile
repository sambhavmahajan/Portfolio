FROM mcr.microsoft.com/openjdk/jdk:25-ubuntu
WORKDIR /wkdir
COPY Portfolio.jar portfolio.jar
ENTRYPOINT ["java", "-jar", "portfolio.jar"]
