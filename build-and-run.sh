#!/bin/bash

# Build the Maven project
mvn package

# Build the Docker image
docker build -t my-docker-java-app .

# Run the Docker container
docker run -p 8080:8080 my-docker-java-app
