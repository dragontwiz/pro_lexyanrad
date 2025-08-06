FROM ubuntu:24.10

RUN apt-get update -y
RUN apt-get install -y default-jre default-jdk 

USER java
WORKDIR /home/java

COPY src .

EXPOSE 5000
