## syntax=docker/dockerfile:1
#
## Comments are provided throughout this file to help you get started.
## If you need more help, visit the Dockerfile reference guide at
## https://docs.docker.com/go/dockerfile-reference/
#
## Want to help us make this template better? Share your feedback here: https://forms.gle/ybq9Krt8jtBL3iCk7
#
#################################################################################
## Pick a base image to serve as the foundation for the other build stages in
## this file.
##
## For illustrative purposes, the following FROM command
## is using the alpine image (see https://hub.docker.com/_/alpine).
## By specifying the "latest" tag, it will also use whatever happens to be the
## most recent version of that image when you build your Dockerfile.
## If reproducability is important, consider using a versioned tag
## (e.g., alpine:3.17.2) or SHA (e.g., alpine@sha256:c41ab5c992deb4fe7e5da09f67a8804a46bd0592bfdf0b1847dde0e0889d2bff).
##FROM alpine:latest as base
##FROM tomcat:9.0.88
#
#################################################################################
## Create a stage for building/compiling the application.
##
## The following commands will leverage the "base" stage above to generate
## a "hello world" script and make it executable, but for a real application, you
## would issue a RUN command for your application's build process to generate the
## executable. For language-specific examples, take a look at the Dockerfiles in
## the Awesome Compose repository: https://github.com/docker/awesome-compose
##FROM base as build
##RUN echo -e '#!/bin/sh\n\
##echo Hello world from $(whoami)! In order to get your application running in a container, take a look at the comments in the Dockerfile to get started.'\
##> /bin/hello.sh
##RUN chmod +x /bin/hello.sh
#
#################################################################################
## Create a final stage for running your application.
##
## The following commands copy the output from the "build" stage above and tell
## the container runtime to execute it when the image is run. Ideally this stage
## contains the minimal runtime dependencies for the application as to produce
## the smallest image possible. This often means using a different and smaller
## image than the one used for building the application, but for illustrative
## purposes the "base" image is used here.
##FROM base AS final
#
## Create a non-privileged user that the app will run under.
## See https://docs.docker.com/go/dockerfile-user-best-practices/
##ARG UID=10001
##RUN adduser \
##    --disabled-password \
##    --gecos "" \
##    --home "/nonexistent" \
##    --shell "/sbin/nologin" \
##    --no-create-home \
##    --uid "${UID}" \
##    appuser
##USER appuser
##
### Copy the executable from the "build" stage.
##COPY --from=build /bin/hello.sh /bin/
##
### What the container should run when it is started.
##ENTRYPOINT [ "/bin/hello.sh" ]
#
##ADD target/CS160_Project-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
##
##EXPOSE 8080
##
##CMD ["catalina.sh", "run"]
#
## Start with a base image containing Java runtime
##FROM maven:3.9.6-openjdk-11-slim AS build
#FROM maven:3.8.4-openjdk-11-slim AS build
#
## The application's .jar file
##ARG JAR_FILE=target/*.war
#
## cd into the app directory
#WORKDIR /usr/src/app
#
## Copy maven executable to the image
#COPY mvnw .
#COPY .mvn .mvn
#
## Copy the pom.xml file
#COPY pom.xml .
##RUN mvn -f /home/app/pom.xml verify clean --fail-never
#
## Build all dependencies for offline use
#RUN ./mvnw dependency:go-offline -B
#
## Copy your other files
#COPY src src
##RUN mvn -f /home/app/pom.xml package
#
## Build the application
##./mvnw package -DskipTests
#RUN mvn package
#
## Start with Tomcat base image
#FROM tomcat:9.0.53-jdk11-openjdk-slim
#
## Set the working directory in the Tomcat container
##WORKDIR /usr/local/tomcat
#
## Copy the war file to the tomcat webapps directory
##COPY --from=build /usr/src/app/target/CS160_Project-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
#
## Copy the WAR file from the Maven build stage into the Tomcat container
#COPY --from=build /usr/src/app/target/*.war ./webapps/
#
## Copy the compiled Java classes into the Tomcat container
#COPY --from=build /usr/src/app/target/classes/ ./webapps/ROOT/WEB-INF/classes/
#
## Copy the JSP files and other web assets into the Tomcat container
#COPY src/main/webapp ./webapps/ROOT/
#
## Expose port 8080 for the application
#EXPOSE 8080
#
## Start Tomcat server
#CMD ["catalina.sh", "run"]


FROM tomcat:9.0.88-jdk21

COPY ./target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]