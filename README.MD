# BasicApp

This is a simple Spring Boot application that demonstrates basic REST API functionality.

## Installation

1. Install Docker Desktop on your machine by following the instructions on the official website: https://www.docker.com/products/docker-desktop
2. Clone this repository to your local machine.

## Building and Running

To build and run the application, execute the following command in the root directory of the project:

```./build-and-run-simple-spring-application.sh```


The script will do the following:

1. Build the Maven project
2. Build the Docker image
3. Run the Docker container

## Usage

Once the container is up and running, you can access the following endpoints:

1. `/hello` - Returns a simple "Hello" message along with the current time.
2. `/setName/{name}` - Sets the name of the application to the given name.
3. `/reverse?input={input}` - Reverses the given input string and returns the result.
4. `/lastReversed` - Returns the last input string that was reversed.

## Acknowledgements

This project was created with the help of OpenJDK, Spring Boot, and Docker.
