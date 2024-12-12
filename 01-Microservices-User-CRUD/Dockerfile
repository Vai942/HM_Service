FROM openjdk:17-jdk-alpine
MAINTAINER "Ashu"
EXPOSE 7000
COPY ./target/UserFile.jar  UserFile.jar
CMD ["java","-jar","UserFile.jar"]

#CMD ["java","-Dspring.profiles.active="development", "-jar","product.war"]
#WORKDIR  /usr/local/bin/