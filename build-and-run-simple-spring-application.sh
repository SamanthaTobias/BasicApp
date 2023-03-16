#!/bin/bash

# Build the Maven project
mvn package #-Dspring.config.location=classpath:application.properties

# Build the Docker image
docker build -t my-docker-java-app .

# Run the Docker container
docker run -p 9000:9000 my-docker-java-app