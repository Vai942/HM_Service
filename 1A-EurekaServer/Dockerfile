FROM openjdk:8u131-jdk-alpine
MAINTAINER "Ashu"
EXPOSE 7000
COPY ./target/DockerFile.jar  DockerFile.jar
CMD ["java","-jar","DockerFile.jar"]

#CMD ["java","-Dspring.profiles.active="development", "-jar","product.war"]
#WORKDIR  /usr/local/bin/