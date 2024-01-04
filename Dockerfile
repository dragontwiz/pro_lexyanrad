FROM ubuntu:latest

RUN apt-get update -y
RUN apt-get install -y default-jre default-jdk 

USER java
WORKDIR /home/java

COPY src .

EXPOSE 5000
